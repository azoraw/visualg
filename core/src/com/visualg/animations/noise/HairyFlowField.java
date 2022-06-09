package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.animations.noise.flow.HairyFlowFieldAlg;
import com.visualg.util.libgdx.TransparentActor;

public class HairyFlowField extends TransparentActor {

    private final HairyFlowFieldAlg alg;
    private final ShapeRenderer sr;

    public HairyFlowField() {
        alg = new HairyFlowFieldAlg();
        sr = new ShapeRenderer();
        Color color = new Color(1, 1, 1, 0.01f);
        sr.setColor(color);
    }

    @Override
    protected void drawFrame() {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        alg.getDots().forEach(dot ->
                sr.circle(dot.getX(), dot.getY(), 1)
        );
        sr.end();
        alg.update();
    }
}
