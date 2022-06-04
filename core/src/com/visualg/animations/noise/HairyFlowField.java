package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.noise.flow.HairyFlowFieldAlg;
import com.visualg.global.Config;
import com.visualg.global.RefreshType;

public class HairyFlowField extends Actor {

    private ShapeRenderer sr;
    private HairyFlowFieldAlg alg;
    private Color color = new Color(1, 1, 1, 0.06f);

    public HairyFlowField() {
        sr = new ShapeRenderer();
        sr.setColor(color);
        alg = new HairyFlowFieldAlg();
        Config.refreshType = RefreshType.BLEND;
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
