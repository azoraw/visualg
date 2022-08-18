package com.visualg.animations.bezier;

import com.badlogic.gdx.math.Vector2;

import static com.visualg.util.RandomGenerator.getIntInRange;

class BouncingBall {

    private final int speed;
    private final int x0;
    private final int y0;
    private final int x1;
    private final int y1;

    private Vector2 position;
    private Vector2 movementDirection;

    BouncingBall(int y1, int x0, int y0, int x1, int speed) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.speed = speed;
        randomDirection();
    }

    private void randomDirection() {
        position = new Vector2(getIntInRange(x0, x1), getIntInRange(y0, y1));
        movementDirection = new Vector2(getIntInRange(-1 * speed, speed), getIntInRange(-1 * speed, speed));
    }

    Vector2 getPosition() {
        return position.cpy();
    }

    void update() {
        position.add(movementDirection);

        if (position.x < x0 || position.x > x1) {
            movementDirection.scl(-1, 1);
        }
        if (position.y < y0 || position.y > y1) {
            movementDirection.scl(1, -1);
        }
    }
}
