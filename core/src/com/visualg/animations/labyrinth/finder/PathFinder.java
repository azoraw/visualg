package com.visualg.animations.labyrinth.finder;


import com.visualg.animations.labyrinth.Cell;
import com.visualg.util.Direction;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.animations.labyrinth.LabyrinthGeneratorActor.GRID_HEIGHT;
import static com.visualg.animations.labyrinth.LabyrinthGeneratorActor.GRID_WIDTH;


@RequiredArgsConstructor
abstract class PathFinder {

    protected final Cell[][] cells;

    abstract void update();

    protected List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        Direction.getAllReducedBy(cell.getWalls())
                .forEach(
                        direction -> {
                            int x = cell.getX();
                            int y = cell.getY();
                            switch (direction) {
                                case UP -> y--;
                                case RIGHT -> x++;
                                case DOWN -> y++;
                                case LEFT -> x--;
                            }
                            if (isInsideGrid(x, y)) {
                                neighbours.add(cells[x][y]);
                            }
                        }
                );
        return neighbours;
    }

    private boolean isInsideGrid(int x, int y) {
        return x >= 0 && x < GRID_WIDTH && y >= 0 && y < GRID_HEIGHT;
    }

}
