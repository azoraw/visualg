package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.libgdx.TransparentActor;

public class TransparentLinesActor extends TransparentActor {

    private final HairyFlowFieldAlg alg;

    public TransparentLinesActor() {
        Color color = new Color(1, 1, 1, 0.00785f);
        sr.setColor(color);
        alg = new HairyFlowFieldAlg();
    }

    @Override
    protected void drawFrame() {
        alg.getDots().forEach(dot ->
                sr.line(dot.getX(), dot.getY(), dot.getX2(), dot.getY2())
        );
        alg.update();
    }
}
