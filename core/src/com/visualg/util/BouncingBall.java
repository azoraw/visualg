package com.visualg.util;

import com.badlogic.gdx.math.Vector2;

import static com.visualg.util.RandomDecorator.Random;

public class BouncingBall {

    private final int speed;
    private final float x0;
    private final float y0;
    private final float x1;
    private final float y1;

    private Vector2 position;
    private Vector2 movementDirection;

    public BouncingBall(int y1, int x0, int y0, int x1, int speed) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.speed = speed;
        randomDirection();
    }

    private void randomDirection() {
        position = new Vector2(Random.getIntInRange((int) x0, (int) x1), Random.getIntInRange((int) y0, (int) y1));
        movementDirection = new Vector2(Random.getFloatInRange(-1 * speed, speed), Random.getFloatInRange(-1 * speed, speed));
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public void update() {
        position.add(movementDirection);
        bounce();
    }

    private void bounce() {
        if (position.x < x0 || position.x > x1) {
            movementDirection.scl(-1, 1);
        }
        if (position.y < y0 || position.y > y1) {
            movementDirection.scl(1, -1);
        }
    }
}
