package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.libgdx.TransparentActor;

public class HairyFlowFieldActor extends TransparentActor {

    private final HairyFlowFieldAlg alg;

    public HairyFlowFieldActor() {
        alg = new HairyFlowFieldAlg();
        Color color = new Color(1, 1, 1, 0.01f);
        sr.setColor(color);
    }

    @Override
    protected void drawFrame() {
        alg.getDots().forEach(dot ->
                sr.circle(dot.getX(), dot.getY(), 1)
        );
        alg.update();
    }
}
