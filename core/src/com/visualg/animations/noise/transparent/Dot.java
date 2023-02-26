package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;
import com.visualg.util.color.ColorGenerator;

import static com.visualg.animations.noise.transparent.TransparentSettings.settings;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;
import static com.visualg.util.RandomDecorator.Random;

class Dot {
    private static final float maxSpeed = 1;

    private final Vector2 initPosition;
    private final Vector2 position;
    private final Vector2 velocity;
    private final Vector2 acceleration;
    private final int randomColorDelta;
    private final Color primaryColor = palette.getPrimaryColor();
    private Color color = new Color(primaryColor.r, primaryColor.g, primaryColor.b, settings.getAlpha());

    Dot() {
        float x = Random.nextInt(WIDTH);
        float y = Random.nextInt(HEIGHT);
        position = new Vector2(x, y);
        initPosition = new Vector2(position);
        velocity = initVelocity();
        acceleration = new Vector2(0, 0);
        randomColorDelta = settings.getRandomColorDelta();

    }

    private Vector2 initVelocity() {
        final Vector2 velocity;
        velocity = new Vector2(0, 1);
        velocity.setAngleRad(Random.getRandomFloat(Math.PI * 4));
        return velocity;
    }

    int getX() {
        return (int) position.x;
    }

    int getY() {
        return (int) position.y;
    }

    int getInitX() {
        return (int) initPosition.x;
    }

    int getInitY() {
        return (int) initPosition.y;
    }

    Color getColor() {
        switch (settings.getColors()) {
            case MONOCHROMATIC -> {
                return color;
            }
            case SMALL_RANGE -> {
                final Pair<Float, Float> colorInput = getColorInput();
                var rad = Math.atan2(colorInput.first(), colorInput.second());
                var angle = rad * (180 / Math.PI);
                color = ColorGenerator.fromHSV(randomColorDelta + (float) angle / 4, 1, 1);
                color.a = settings.getAlpha();
                return color;
            }
            case FULL_PALETTE -> {
                final Pair<Float, Float> colorInput = getColorInput();
                var rad = Math.atan2(colorInput.first(), colorInput.second());
                var angle = rad * (180 / Math.PI);
                color = ColorGenerator.fromHSV((float) angle, 1, 1);
                color.a = settings.getAlpha();
                return color;
            }
            case SINGLE_RANDOM -> {
                color = ColorGenerator.fromHSV(randomColorDelta, 1, 1);
                color.a = settings.getAlpha();
                return color;
            }
        }
        return color;
    }

    private Pair<Float, Float> getColorInput() {
        switch (settings.getColorInputSrc()) {
            case POSITION -> {
                return new Pair<>( position.x - WIDTH / 2,  position.y - HEIGHT / 2);
            }
            case VELOCITY -> {
                return new Pair<>(velocity.x,  velocity.y);

            }
            case FIELD -> {
                return new Pair<>( acceleration.x, acceleration.y);
            }
        }
        throw new RuntimeException();
    }

    void moveWithFlow(Vector2 vector2) {
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        position.add(velocity);
        acceleration.set(vector2.x * settings.getFieldMagnitude(), vector2.y * settings.getFieldMagnitude());
        edge();
    }

    private void edge() {
        if (position.x < 0) position.set(WIDTH, position.y);
        if (position.y < 0) position.set(position.x, HEIGHT);
        if (position.x > WIDTH) position.set(0, position.y);
        if (position.y > HEIGHT) position.set(position.x, 0);
    }
}
