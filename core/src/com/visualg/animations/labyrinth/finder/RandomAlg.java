package com.visualg.animations.labyrinth.finder;

import com.visualg.animations.labyrinth.Cell;
import lombok.Getter;

import java.util.List;
import java.util.Random;

import static com.visualg.animations.labyrinth.LabyrinthGeneratorActor.GRID_HEIGHT;
import static com.visualg.animations.labyrinth.LabyrinthGeneratorActor.GRID_WIDTH;


class RandomAlg extends PathFinder {

    private static final int INIT_POSITION_X = 0;
    private static final int INIT_POSITION_Y = 0;
    private final Random random = new Random();

    @Getter
    private Cell currentCell;

    RandomAlg(Cell[][] cells) {
        super(cells);
        currentCell = cells[INIT_POSITION_X][INIT_POSITION_Y];
        currentCell.setCurrent(true);
    }


    void update() {
        if (!(currentCell.getX() == GRID_WIDTH - 1 && currentCell.getY() == GRID_HEIGHT - 1)) {
            Cell randomNeighbour = getRandomNeighbour(getNeighbours(currentCell));
            currentCell.setCurrent(false);
            currentCell = randomNeighbour;
            currentCell.setCurrent(true);
        }
    }

    private Cell getRandomNeighbour(List<Cell> neighbours) {
        return neighbours.get(random.nextInt(neighbours.size()));
    }
}
