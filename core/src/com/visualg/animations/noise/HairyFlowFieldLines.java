package com.visualg.animations.noise;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;
import com.visualg.global.RefreshType;
import com.visualg.animations.noise.flow.HairyFlowFieldAlg;

public class HairyFlowFieldLines extends Actor {

    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private HairyFlowFieldAlg alg;
    private Color color = new Color(1,1,1,0.00785f);

    public HairyFlowFieldLines() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(color);
        alg = new HairyFlowFieldAlg(WIDTH, HEIGHT);
        Config.refreshType = RefreshType.BLEND;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        alg.getDots().forEach(dot ->
                sr.line(dot.getX(), dot.getY(), dot.getX2(), dot.getY2())
        );
        sr.end();
        alg.update();
    }

}
