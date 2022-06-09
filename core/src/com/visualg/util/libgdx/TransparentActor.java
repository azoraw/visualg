package com.visualg.util.libgdx;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.RefreshType.BLEND;

public abstract class TransparentActor extends Actor {

    private final FrameBuffer fbo;

    public TransparentActor() {
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, WIDTH, HEIGHT, false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        fbo.begin();
        BLEND.refresh();
        drawFrame();
        fbo.end();
        batch.begin();
        batch.draw(fbo.getColorBufferTexture(), 0, 0, WIDTH, HEIGHT, 0, 0, 1, 1);
    }

    protected abstract void drawFrame();
}
