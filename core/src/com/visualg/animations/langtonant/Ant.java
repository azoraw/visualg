package com.visualg.animations.langtonant;

import com.visualg.util.Direction;

import static com.visualg.util.Direction.UP;

class Ant {
    private final int width;
    private final int height;
    int x;
    int y;
    private Direction currentDirection;

    Ant(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = width / 2;
        this.y = height / 2;
        currentDirection = UP;
    }

    void moveCounterClockwise() {
        currentDirection = currentDirection.counterClockwise;
        move();
    }

    void moveClockwise() {
        currentDirection = currentDirection.clockwise;
        move();
    }

    private void move() {
        switch (currentDirection) {
            case UP -> y++;
            case DOWN -> y--;
            case RIGHT -> x++;
            case LEFT -> x--;
        }
        limit();
    }

    private void limit() {
        if (x < 0) {
            x = width - 1;
        } else if (x == width) {
            x = 0;
        } else if (y < 0) {
            y = height - 1;
        } else if (y == height) {
            y = 0;
        }
    }
}
