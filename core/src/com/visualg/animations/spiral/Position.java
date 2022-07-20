package com.visualg.animations.spiral;


import com.visualg.util.Direction;

import static com.visualg.animations.spiral.ulam.UlamSpiralAlg.SIDE_LENGTH;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class Position {

    private int x = WIDTH / 2;
    private int y = HEIGHT / 2;
    private Direction direction = Direction.RIGHT;
    private Spiral spiral = new Spiral();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        moveInCurrentDirection();
        spiral.incrementCurrentSideLength();
    }

    public void turn() {
        if (spiral.canTurn()) {
            direction = direction.clockwise;
            spiral.resetCurrentSideLength();
            if (canIncreaseSpiralSide()) {
                spiral.incrementSideLength();
            }
        }
    }

    public boolean isInsideDrawableArea() {
        return x >= 0 && x < SIDE_LENGTH && y >= 0 && y < SIDE_LENGTH;
    }

    private void moveInCurrentDirection() {
        switch (direction) {
            case RIGHT:
                x++;
                break;
            case UP:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case DOWN:
                y++;
                break;
        }
    }


    private boolean canIncreaseSpiralSide() {
        return direction == Direction.RIGHT || direction == Direction.LEFT;
    }

}

