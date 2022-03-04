package com.visualg.noise;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.noise.flow.FlowFieldAlg;

public class FlowField extends Actor {

    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private FlowFieldAlg alg;

    public FlowField() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        alg = new FlowFieldAlg(WIDTH, HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        for (int x = 0; x < WIDTH / alg.scale; x++) {
            for (int y = 0; y < HEIGHT / alg.scale; y++) {
                sr.line(x * (int) alg.scale, y * (int) alg.scale, alg.getXCoordinate(x, y), alg.getYCoordinate(x, y));
            }
        }
        sr.end();
        alg.update();
        batch.begin();
    }
}
