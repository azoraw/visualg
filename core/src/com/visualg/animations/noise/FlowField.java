package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.noise.flow.FlowFieldAlg;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class FlowField extends Actor {

    private ShapeRenderer sr;
    private FlowFieldAlg alg;

    public FlowField() {
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        alg = new FlowFieldAlg();
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
