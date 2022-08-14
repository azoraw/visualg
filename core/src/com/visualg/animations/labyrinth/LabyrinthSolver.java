package com.visualg.animations.labyrinth;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.labyrinth.finder.AStarAlg;
import com.visualg.global.Config;
import com.visualg.util.Direction;

import java.util.Map;

public class LabyrinthSolver extends Actor {

    static final int CELL_WIDTH = 10;
    static final int CELL_HEIGHT = 10;
    public static final int GRID_WIDTH = Config.WIDTH / CELL_WIDTH;
    public static final int GRID_HEIGHT = Config.HEIGHT / CELL_HEIGHT;

    private final SpriteBatch batch;
    private Map<Direction, Texture> wallTextures;
    private Map<Color, Texture> backgroundTextures;
    private Cell[][] cells;
    private final AStarAlg aStarAlg;

    public LabyrinthSolver() {
        createTextures();
        createBacktracker();
        batch = new SpriteBatch();
        drawGrid();
        aStarAlg = new AStarAlg(cells);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawGrid();
        drawRandomFinder();
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            aStarAlg.update();
        }
    }

    private void drawRandomFinder() {
        Cell currentCell = aStarAlg.getCurrentCell();
        batch.begin();
        batch.draw(backgroundTextures.get(Color.WHITE), currentCell.getX() * CELL_WIDTH, (GRID_HEIGHT - currentCell.getY() - 1) * CELL_HEIGHT);
        batch.end();
    }

    private void createBacktracker() {
        cells = new Cell[GRID_WIDTH][GRID_HEIGHT];
        Backtracker backtracker = new Backtracker(cells);
        backtracker.fullRun();
    }

    private void createTextures() {
        backgroundTextures = TextureFactory.createBackgroundTextures();
        wallTextures = TextureFactory.createWallTextures();
    }

    private void drawGrid() {
        batch.begin();
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                Cell cell = cells[x][GRID_HEIGHT - y - 1];
                Texture backgroundColor = getBackgroundTexture(cell);
                batch.draw(backgroundColor, x * CELL_WIDTH, y * CELL_HEIGHT);
                drawWalls(x, y, cell);
            }
        }
        batch.end();
    }

    private Texture getBackgroundTexture(Cell cell) {
        Color backgroundColor = getBackgroundColor(cell);
        return backgroundTextures.get(backgroundColor);
    }

    private Color getBackgroundColor(Cell cell) {
        if (cell.isOnStack()) {
            return Color.BLUE;
        } else if (cell.isVisited()) {
            return Color.GREEN;
        }
        return Color.RED;
    }

    private void drawWalls(int x, int y, Cell cell) {
        for (Direction direction : cell.getWalls()) {
            batch.draw(wallTextures.get(direction), x * CELL_WIDTH, y * CELL_HEIGHT);
        }
    }
}
