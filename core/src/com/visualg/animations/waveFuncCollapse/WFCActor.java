package com.visualg.animations.waveFuncCollapse;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.waveFuncCollapse.texture.WFCTextures;
import com.visualg.controls.fileio.ScreenShotSaver;
import com.visualg.global.Config;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class WFCActor extends Actor {
    private static int cellSize = 20;

    private final SpriteBatch spriteBatch;
    private final WFCTextures textures;
    private final WFCAlg alg;
    private boolean canTakeScreenShot = false;
    int cellsX;
    int cellsY;


    public WFCActor() {
        spriteBatch = new SpriteBatch();
        textures = new WFCTextures();
        if (Settings.INSTANCE.variant == Variant.CARRCAS) {
            cellSize = 40;
        }
        cellsX = WIDTH / cellSize;
        cellsY = HEIGHT / cellSize;
        alg = new WFCAlg(cellsX, cellsY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawGrid();
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            alg.update();
        }
    }

    private void drawGrid() {
        spriteBatch.begin();
        for (int y = 0; y < cellsY; y++) {
            for (int x = 0; x < cellsX; x++) {
                spriteBatch.draw(textures.get(alg.getCells()[x][y].solution), x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
        if (canTakeScreenShot) {
            ScreenShotSaver.take(Pixmap.createFromFrameBuffer(0, 0, WIDTH, HEIGHT));
            canTakeScreenShot = false;
        }
        spriteBatch.end();
    }

    void takeScreenShot() {
        canTakeScreenShot = true;
    }
}
