package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.animations.noise.flow.HairyFlowFieldAlg;
import com.visualg.util.libgdx.TransparentActor;

public class HairyFlowFieldLines extends TransparentActor {

    private final ShapeRenderer sr;
    private final HairyFlowFieldAlg alg;

    public HairyFlowFieldLines() {
        sr = new ShapeRenderer();
        Color color = new Color(1, 1, 1, 0.00785f);
        sr.setColor(color);
        alg = new HairyFlowFieldAlg();
    }

    @Override
    protected void drawFrame() {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        alg.getDots().forEach(dot ->
                sr.line(dot.getX(), dot.getY(), dot.getX2(), dot.getY2())
        );
        sr.end();
        alg.update();
    }

}
