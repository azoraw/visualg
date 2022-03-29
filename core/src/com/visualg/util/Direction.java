package com.visualg.util;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public Direction clockwise;
    public Direction counterClockwise;

    static {
        UP.clockwise = RIGHT;
        UP.counterClockwise = LEFT;

        DOWN.clockwise = LEFT;
        DOWN.counterClockwise = RIGHT;

        RIGHT.clockwise = DOWN;
        RIGHT.counterClockwise = UP;

        LEFT.clockwise = UP;
        LEFT.counterClockwise = DOWN;
    }
}
