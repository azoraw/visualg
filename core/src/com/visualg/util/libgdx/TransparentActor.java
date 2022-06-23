package com.visualg.util.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.RefreshType.BLEND;

public abstract class TransparentActor extends Actor {

    private final FrameBuffer fbo;
    protected final ShapeRenderer sr;
    private boolean takeScreenShot = false;
    private boolean backgroundClear = true;

    public TransparentActor() {
        sr = new ShapeRenderer();
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, WIDTH, HEIGHT, false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        fbo.begin();
        BLEND.refresh();
        sr.begin(Filled);
        blackBackground();
        drawFrame();
        sr.end();
        screenShot();
        fbo.end();
        batch.begin();
        batch.draw(fbo.getColorBufferTexture(), 0, 0, WIDTH, HEIGHT, 0, 0, 1, 1);
    }

    private void blackBackground() {
        if (backgroundClear) {
            backgroundClear = false;
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
