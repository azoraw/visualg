package com.visualg.noise.flow;

import com.badlogic.gdx.math.Vector2;
import com.visualg.noise.util.RandomGenerator;

import static com.visualg.noise.util.RandomGenerator.getIntInRange;

public class Dot {
    private final int WIDHT;
    private final int HEIGHT;
    private final float maxSpeed = 2;
    private final float fieldMagnitude = 0.05f;

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    public Dot(int width, int height) {
        WIDHT = width;
        HEIGHT = height;
        float x = getIntInRange(width);
        float y = getIntInRange(height);
        position = new Vector2(x, y);
        velocity = new Vector2(0, 4);
        velocity.setAngleRad(RandomGenerator.getRandomFloat(Math.PI * 4));
        acceleration = new Vector2(0, 0);
    }

    public int getX() {
        return (int) position.x;
    }

    public int getY() {
        return (int) position.y;
    }

    public void moveWithFlow(Vector2 vector2) {
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        position.add(velocity);
        acceleration.set(vector2.x * fieldMagnitude, vector2.y * fieldMagnitude);
        edge();
    }

    private void edge() {
        if (position.x < 0) position.set(WIDHT, position.y);
        if (position.y < 0) position.set(position.x, HEIGHT);
        if (position.x > WIDHT) position.set(0, position.y);
        if (position.y > HEIGHT) position.set(position.x, 0);
    }
}
