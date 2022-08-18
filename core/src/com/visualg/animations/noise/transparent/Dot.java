package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.RandomGenerator;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.util.RandomGenerator.getIntInRange;

class Dot {
    private static final float maxSpeed = 1;
    private static final float fieldMagnitude = 0.01f;

    private final Vector2 prevPosition;
    private final Vector2 position;
    private final Vector2 velocity;
    private final Vector2 acceleration;

    Dot() {

        float x = getIntInRange(WIDTH);
        float y = getIntInRange(HEIGHT);
        position = new Vector2(x, y);
        prevPosition= new Vector2(position);
        velocity = new Vector2(0, 1);
        velocity.setAngleRad(RandomGenerator.getRandomFloat(Math.PI * 4));
        acceleration = new Vector2(0, 0);
    }

    int getX() {
        return (int) position.x;
    }

    int getY() {
        return (int) position.y;
    }

    int getX2() {
        return (int) prevPosition.x;
    }

    int getY2() {
        return (int) prevPosition.y;
    }

    void moveWithFlow(Vector2 vector2) {
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        position.add(velocity);
        acceleration.set(vector2.x * fieldMagnitude, vector2.y * fieldMagnitude);
        edge();
    }

    private void edge() {
        if (position.x < 0) position.set(WIDTH, position.y);
        if (position.y < 0) position.set(position.x, HEIGHT);
        if (position.x > WIDTH) position.set(0, position.y);
        if (position.y > HEIGHT) position.set(position.x, 0);
    }
}
