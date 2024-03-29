package com.visualg.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

import static com.visualg.global.Config.palette;

public abstract class ShapeRendererActor extends Actor {

    protected final ShapeRenderer.ShapeType shapeType;
    protected final ShapeRendererExtended sr;

    protected ShapeRendererActor(ShapeRenderer.ShapeType shapeType) {
        this.shapeType = shapeType;
        sr = new ShapeRendererExtended();
        sr.setColor(palette.getPrimaryColor());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(shapeType);
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            drawFrame();
        }
        sr.end();
        batch.begin();
    }

    protected abstract void drawFrame();
}
