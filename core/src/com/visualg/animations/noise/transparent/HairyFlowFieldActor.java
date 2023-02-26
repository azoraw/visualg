package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;

import static com.visualg.animations.noise.transparent.TransparentSettings.settings;

class HairyFlowFieldActor extends FrameBufferActor {

    private final HairyFlowFieldAlg alg;

    HairyFlowFieldActor() {
        super(true);
        super.tiles = settings.getTiles();
        alg = new HairyFlowFieldAlg(settings);
        final Color primaryColor = Config.palette.getPrimaryColor();
        Color color = new Color(primaryColor.r, primaryColor.g, primaryColor.b, settings.getAlpha());
        sr.setColor(color);
        for (int i = 0; i < settings.getInitFrameSkips(); i++) {
            alg.update();
        }
    }

    @Override
    protected void drawFrame() {
        alg.getDots().forEach(dot -> {
                    sr.setColor(dot.getColor());
                    if (settings.isConnectedWithStartingPoint())
                        sr.line(dot.getX(), dot.getY(), dot.getInitX(), dot.getInitY());
                    else
                        sr.circle(dot.getX(), dot.getY(), 1);
                }
        );
        alg.update();
    }
}
