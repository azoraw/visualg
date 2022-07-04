package com.visualg.animations.labyrinth;

import com.visualg.util.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;

@Getter
public class Cell {

    private final int x;
    private final int y;

    private final EnumSet<Direction> walls = EnumSet.allOf(Direction.class);

    @Setter
    private boolean current;
    @Setter
    private boolean visited;
    @Setter
    private boolean onStack;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Direction getDirection(Cell cell) {
        if (x < cell.getX()) {
            return Direction.RIGHT;
        }
        if (x > cell.getX()) {
            return Direction.LEFT;
        }
        if (y < cell.getY()) {
            return Direction.DOWN;
        }
        if (y > cell.getY()) {
            return Direction.UP;
        }
        return null;
    }

    public void removeWall(Direction wall) {
        walls.remove(wall);
    }
}
