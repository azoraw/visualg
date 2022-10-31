package com.visualg.animations.waveFuncCollapse;

import com.visualg.animations.waveFuncCollapse.rules.Rules;
import com.visualg.util.Direction;
import lombok.Getter;

import java.util.ArrayDeque;
import java.util.TreeSet;

import static com.visualg.util.Direction.DOWN;
import static com.visualg.util.Direction.LEFT;
import static com.visualg.util.Direction.RIGHT;
import static com.visualg.util.Direction.UP;

class WFCAlg {
    @Getter
    private final Cell[][] cells;
    private final TreeSet<Cell> sortedCells = new TreeSet<>();
    private final ArrayDeque<Cell> collapsedCells = new ArrayDeque<>();
    private final int dimX;
    private final int dimY;
    private final Rules rules;

    WFCAlg(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        cells = new Cell[dimX][dimY];
        rules = new Rules();
        initCells();
        //initBorders();
    }

    private void initCells() {
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                Cell newCell = new Cell(x, y, rules);
                cells[x][y] = newCell;
                sortedCells.add(newCell);
            }
        }
    }

    private void initBorders() {
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (x == 0) {
                    cells[x][y].collapsed(1);
                    collapse(cells[x][y]);
                }
                if (y == 0) {
                    cells[x][y].collapsed(1);
                    collapse(cells[x][y]);
                }
                if (x == dimX - 1) {
                    cells[x][y].collapsed(1);
                    collapse(cells[x][y]);
                }
                if (y == dimY - 1) {
                    cells[x][y].collapsed(1);
                    collapse(cells[x][y]);
                }
            }
        }
    }


    void update() {
        if (sortedCells.isEmpty()) {
            return;
        }
        Cell currentCell;
        if (!collapsedCells.isEmpty()) {
            currentCell = collapsedCells.pop();

        } else {
            currentCell = sortedCells.first();
            sortedCells.remove(currentCell);
            currentCell.collapse();
        }
        collapseNotCollapsedNeighbours(currentCell);
    }

    private void collapseNotCollapsedNeighbours(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        collapseNeighbour(x, y + 1, cell.solution, UP);
        collapseNeighbour(x + 1, y, cell.solution, RIGHT);
        collapseNeighbour(x, y - 1, cell.solution, DOWN);
        collapseNeighbour(x - 1, y, cell.solution, LEFT);
    }

    boolean collapseNeighbour(int x, int y, int collapsedValue, Direction dir) {
        if (isInsideGrid(x, y) && isNotCollapsed(x, y)) {
            boolean collapsed = false;
            try {
                collapsed = cells[x][y].collapse(collapsedValue, dir);

            } catch (Exception e) {
                //throw e;
            }
            if (collapsed) {
                collapse(cells[x][y]);
            }
        }
        return false;
    }

    private void collapse(Cell cell) {
        sortedCells.remove(cell);
        collapsedCells.add(cell);
    }

    private boolean isNotCollapsed(int x, int y) {
        return !cells[x][y].collapsed;
    }

    private boolean isInsideGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < dimX && y < dimY;
    }
}
