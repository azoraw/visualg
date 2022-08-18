package com.visualg.animations.labyrinth;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;
import com.visualg.util.Direction;
import com.visualg.util.libgdx.ScreenShotUtil;

import java.util.Map;

public class LabyrinthGeneratorActor extends Actor {

    static final int CELL_WIDTH = 10;
    static final int CELL_HEIGHT = 10;
    public static final int GRID_WIDTH = Config.WIDTH / CELL_WIDTH;
    public static final int GRID_HEIGHT = Config.HEIGHT / CELL_HEIGHT;

    private final SpriteBatch spriteBatch;
    private Map<Direction, Texture> wallTextures;
    private Map<Color, Texture> backgroundTextures;
    private Cell[][] cells;
    private boolean canTakeScreenShot = false;
    private Backtracker backtracker;

    LabyrinthGeneratorActor() {
        createTextures();
        createBacktracker();
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawGrid();
        takeScreenShot();
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            backtracker.update();
        }
    }

    private void takeScreenShot() {
        if (canTakeScreenShot)
            ScreenShotUtil.take(Pixmap.createFromFrameBuffer(0, 0, Config.WIDTH, Config.HEIGHT));
        canTakeScreenShot = false;
    }

    private void createBacktracker() {
        cells = new Cell[GRID_WIDTH][GRID_HEIGHT];
        backtracker = new Backtracker(cells);
    }

    private void createTextures() {
        backgroundTextures = TextureFactory.createBackgroundTextures();
        wallTextures = TextureFactory.createWallTextures();
    }

    private void drawGrid() {
        spriteBatch.begin();
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                Cell cell = cells[x][GRID_HEIGHT - y - 1];
                Texture backgroundColor = getBackgroundTexture(cell);
                spriteBatch.draw(backgroundColor, x * CELL_WIDTH, y * CELL_HEIGHT);
                drawWalls(x, y, cell);
            }
        }
        spriteBatch.end();
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
            spriteBatch.draw(wallTextures.get(direction), x * CELL_WIDTH, y * CELL_HEIGHT);
        }
    }

    void screenShot() {
        canTakeScreenShot = true;
    }
}
