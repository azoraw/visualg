package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.libgdx.TransparentActor;

public class HairyFlowFieldActor extends TransparentActor {

    private final HairyFlowFieldAlg alg;
    private final CurrentSettings settings;

    public HairyFlowFieldActor(CurrentSettings settings) {
        this.settings = settings;
        alg = new HairyFlowFieldAlg(settings);
        Color color = new Color(1, 1, 1, settings.getAlpha());
        sr.setColor(color);
    }

    @Override
    protected void drawFrame() {
        alg.getDots().forEach(dot -> {
                    if (settings.isConnectedWithStartingPoint())
                        sr.line(dot.getX(), dot.getY(), dot.getX2(), dot.getY2());
                    else
                        sr.circle(dot.getX(), dot.getY(), 1);
                }
        );
        alg.update();
    }
}
