package com.visualg.langtonant;

enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    Direction clockwise;
    Direction counterClockwise;

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
