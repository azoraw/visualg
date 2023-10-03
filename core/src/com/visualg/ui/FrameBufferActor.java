package com.visualg.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.controls.fileio.ScreenShotSaver;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;
import static com.visualg.global.Config.updatesPerFrame;
import static com.visualg.ui.RefreshType.BLEND;
import static com.visualg.ui.RefreshType.DEFAULT;

public abstract class FrameBufferActor extends Actor implements Recordable {

    protected final ShapeRenderer sr;
    private final FrameBuffer fbo;
    private final boolean transparent;
    protected int tiles = 1;
    private boolean takeScreenShot = false;
    private boolean backgroundCleared = false;

    public FrameBufferActor(boolean transparent) {
        sr = new ShapeRenderer();
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, WIDTH, HEIGHT, false);
        this.transparent = transparent;
        if (transparent) {
            Color color = palette.getPrimaryColor().cpy();
            color.a = 0.01f;
            sr.setColor(color);
        }
        if (ScreenShotSaver.isScheduledToRecordOnNextAnimationStart()) {
            ScreenShotSaver.prepareRecording();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        fbo.begin();
        if (transparent) {
            BLEND.refresh();
        } else {
            DEFAULT.refresh();
        }
        sr.begin(Filled);
        clearBackground();
        for (int i = 0; i < updatesPerFrame; i++) {
            drawFrame();
        }
        sr.end();
        screenShot();
        record();
        fbo.end();
        batch.begin();
        for (int x = 0; x < tiles; x++) {
            for (int y = 0; y < tiles; y++) {
                batch.draw(fbo.getColorBufferTexture(), x * WIDTH / tiles, y * HEIGHT / tiles, WIDTH / tiles, HEIGHT / tiles);
            }
        }
    }

    private void clearBackground() {
        if (!backgroundCleared) {
            backgroundCleared = true;
            sr.rect(0, 0, fbo.getWidth(), fbo.getHeight(),
                    palette.getBackground(),
                    palette.getBackground(),
                    palette.getBackground(),
                    palette.getBackground());
        }
    }

    private void screenShot() {
        if (takeScreenShot) {
            ScreenShotSaver.take(Pixmap.createFromFrameBuffer(0, 0, fbo.getWidth(), fbo.getHeight()));
            takeScreenShot = false;
        }
    }

    @Override
    public void record() {
        if (ScreenShotSaver.isRecording()) {
            ScreenShotSaver.record(Pixmap.createFromFrameBuffer(0, 0, fbo.getWidth(), fbo.getHeight()));
        }
    }

    protected abstract void drawFrame();

    public Runnable onScreenShot() {
        return () -> takeScreenShot = true;
    }
}
