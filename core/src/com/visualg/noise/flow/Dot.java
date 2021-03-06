package com.visualg.noise.flow;

import com.badlogic.gdx.math.Vector2;
import com.visualg.noise.util.RandomGenerator;

import static com.visualg.noise.util.RandomGenerator.getIntInRange;

public class Dot {
    private static final float maxSpeed = 1;
    private static final float fieldMagnitude = 0.01f;
    private final int WIDHT;
    private final int HEIGHT;

    private final Vector2 prevPosition;
    private final Vector2 position;
    private final Vector2 velocity;
    private final Vector2 acceleration;

    public Dot(int width, int height) {
        WIDHT = width;
        HEIGHT = height;
        float x = getIntInRange(width);
        float y = getIntInRange(height);
        position = new Vector2(x, y);
        prevPosition= new Vector2(position);
        velocity = new Vector2(0, 1);
        velocity.setAngleRad(RandomGenerator.getRandomFloat(Math.PI * 4));
        acceleration = new Vector2(0, 0);
    }

    public int getX() {
        return (int) position.x;
    }

    public int getY() {
        return (int) position.y;
    }

    public int getX2() {
        return (int) prevPosition.x;
    }

    public int getY2() {
        return (int) prevPosition.y;
    }

    public void moveWithFlow(Vector2 vector2) {
        //prevPosition.set(position);
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
