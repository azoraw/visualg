package com.visualg.util.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

public abstract class ShapeRendererActor extends Actor {

    protected final ShapeRenderer.ShapeType shapeType;
    protected final ShapeRenderer sr;

    protected ShapeRendererActor(ShapeRenderer.ShapeType shapeType) {
        this.shapeType = shapeType;
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
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
