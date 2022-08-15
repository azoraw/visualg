package com.visualg.util.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.RefreshType.BLEND;
import static com.visualg.global.RefreshType.DEFAULT;

public abstract class FrameBufferActor extends Actor {

    private final FrameBuffer fbo;
    protected final ShapeRenderer sr;
    private boolean takeScreenShot = false;
    private boolean backgroundCleared = false;
    private boolean transparent = true;

    public FrameBufferActor(boolean transparent) {
        sr = new ShapeRenderer();
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, WIDTH, HEIGHT, false);
        this.transparent = transparent;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        fbo.begin();
        if(transparent) {
            BLEND.refresh();
        } else {
            DEFAULT.refresh();
        }
        sr.begin(Filled);
        blackBackground();
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            drawFrame();
        }
        sr.end();
        screenShot();
        fbo.end();
        batch.begin();
        batch.draw(fbo.getColorBufferTexture(), 0, 0, WIDTH, HEIGHT, 0, 0, 1, 1);
    }

    private void blackBackground() {
        if (!backgroundCleared) {
            backgroundCleared = true;
            sr.rect(0, 0, fbo.getWidth(), fbo.getHeight(), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
        }
    }

    private void screenShot() {
        if (takeScreenShot) {
            ScreenShotUtil.take(Pixmap.createFromFrameBuffer(0, 0, fbo.getWidth(), fbo.getHeight()));
            takeScreenShot = false;
        }
    }

    protected abstract void drawFrame();

    public Runnable onScreenShot() {
        return () -> takeScreenShot = true;
    }
}