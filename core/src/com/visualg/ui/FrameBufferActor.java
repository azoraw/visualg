package com.visualg.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.util.libgdx.ScreenShotUtil;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;
import static com.visualg.global.Config.updatesPerFrame;
import static com.visualg.util.libgdx.RefreshType.BLEND;
import static com.visualg.util.libgdx.RefreshType.DEFAULT;

public abstract class FrameBufferActor extends Actor {

    private final FrameBuffer fbo;
    private final boolean transparent;
    protected final ShapeRenderer sr;
    private boolean takeScreenShot = false;
    private boolean backgroundCleared = false;

    public FrameBufferActor(boolean transparent) {
        sr = new ShapeRenderer();
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, WIDTH, HEIGHT, false);
        this.transparent = transparent;
        if(transparent) {
            Color white = Color.WHITE.cpy();
            white.a = 0.01f;
            sr.setColor(white);
        }
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
        clearBackground();
        for (int i = 0; i < updatesPerFrame; i++) {
            drawFrame();
        }
        sr.end();
        screenShot();
        fbo.end();
        batch.begin();
        batch.draw(fbo.getColorBufferTexture(), 0, 0, WIDTH, HEIGHT, 0, 0, 1, 1);
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
            ScreenShotUtil.take(Pixmap.createFromFrameBuffer(0, 0, fbo.getWidth(), fbo.getHeight()));
            takeScreenShot = false;
        }
    }

    protected abstract void drawFrame();

    public Runnable onScreenShot() {
        return () -> takeScreenShot = true;
    }
}
