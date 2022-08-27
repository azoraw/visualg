package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.visualg.util.RandomGenerator;
import com.visualg.util.color.ColorGenerator;

import static com.visualg.animations.noise.transparent.CurrentSettings.INSTANCE;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.util.RandomGenerator.getIntInRange;

class Dot {
    private static final float maxSpeed = 1;

    private final Vector2 initPosition;
    private final Vector2 position;
    private final Vector2 velocity;
    private final Vector2 acceleration;
    private final int randomColorDelta;
    private Color color = new Color(1, 1, 1, INSTANCE.getAlpha());

    Dot() {
        float x = getIntInRange(WIDTH);
        float y = getIntInRange(HEIGHT);
        position = new Vector2(x, y);
        initPosition = new Vector2(position);
        velocity = new Vector2(0, 1);
        velocity.setAngleRad(RandomGenerator.getRandomFloat(Math.PI * 4));
        acceleration = new Vector2(0, 0);
        randomColorDelta = INSTANCE.getRandomColorDelta();

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
        switch (INSTANCE.getColors()) {
            case MONOCHROMATIC -> {
                return color;
            }
            case SMALL_RANGE -> {
                var rad = Math.atan2(velocity.x, velocity.y);
                var angle = rad * (180 / Math.PI);
                color = ColorGenerator.fromHSV(randomColorDelta + (float) angle / 8, 1, 1);
                color.a = INSTANCE.getAlpha();
                return color;
            }
            case FULL_PALETTE -> {
                var rad = Math.atan2(velocity.x, velocity.y);
                var angle = rad * (180 / Math.PI);
                color = ColorGenerator.fromHSV((float) angle, 1, 1);
                color.a = INSTANCE.getAlpha();
                return color;
            }
            case SINGLE_RANDOM -> {
                color = ColorGenerator.fromHSV(randomColorDelta, 1, 1);
                color.a = INSTANCE.getAlpha();
                return color;
            }
        }
        return color;
    }

    void moveWithFlow(Vector2 vector2) {
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        position.add(velocity);
        acceleration.set(vector2.x * INSTANCE.getFieldMagnitude(), vector2.y * INSTANCE.getFieldMagnitude());
        edge();
    }

    private void edge() {
        if (position.x < 0) position.set(WIDTH, position.y);
        if (position.y < 0) position.set(position.x, HEIGHT);
        if (position.x > WIDTH) position.set(0, position.y);
        if (position.y > HEIGHT) position.set(position.x, 0);
    }
}
