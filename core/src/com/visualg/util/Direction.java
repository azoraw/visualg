package com.visualg.util;

import java.util.EnumSet;
import java.util.Set;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    static {
        UP.clockwise = RIGHT;
        UP.counterClockwise = LEFT;

        DOWN.clockwise = LEFT;
        DOWN.counterClockwise = RIGHT;

        RIGHT.clockwise = DOWN;
        RIGHT.counterClockwise = UP;

        LEFT.clockwise = UP;
        LEFT.counterClockwise = DOWN;

        UP.opposite = DOWN;
        RIGHT.opposite = LEFT;
        DOWN.opposite = UP;
        LEFT.opposite = RIGHT;
    }

    public Direction clockwise;
    public Direction counterClockwise;
    public Direction opposite;

    public static Set<Direction> getAllReducedBy(EnumSet<Direction> directions) {
        Set<Direction> reversed = EnumSet.allOf(Direction.class);
        reversed.removeAll(directions);
        return reversed;
    }
}
