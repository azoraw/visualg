package com.visualg.animations.spiral;


import com.visualg.util.Direction;
import lombok.Getter;

import static com.visualg.animations.spiral.ulam.UlamSpiralAlg.SIDE_LENGTH;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class Position {

    private final Spiral spiral = new Spiral();

    @Getter
    private int x = WIDTH / 2;
    @Getter
    private int y = HEIGHT / 2;
    private Direction direction = Direction.RIGHT;

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
            case RIGHT -> x++;
            case UP -> y--;
            case LEFT -> x--;
            case DOWN -> y++;
        }
    }

    private boolean canIncreaseSpiralSide() {
        return direction == Direction.RIGHT || direction == Direction.LEFT;
    }

}

