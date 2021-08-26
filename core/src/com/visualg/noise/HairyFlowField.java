package com.visualg.noise;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;
import com.visualg.noise.flow.HairyFlowFieldAlg;

import static com.visualg.global.RefreshType.BLEND;

public class HairyFlowField extends Actor {

    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private HairyFlowFieldAlg alg;
    private Color color = new Color(1,1,1,0.06f);

    public HairyFlowField() {

        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(color);
        alg = new HairyFlowFieldAlg(WIDTH, HEIGHT);

        Config.refreshType = BLEND;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        alg.getDots().forEach(dot ->
                sr.circle(dot.getX(), dot.getY(), 1)
        );
        sr.end();
        alg.update();
    }

}
