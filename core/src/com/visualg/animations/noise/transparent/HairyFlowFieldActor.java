package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;

class HairyFlowFieldActor extends FrameBufferActor {

    private final HairyFlowFieldAlg alg;
    private final TransparentSettings transparentSettings;

    HairyFlowFieldActor(TransparentSettings transparentSettings) {
        super(true);
        super.tiles = transparentSettings.getTiles();
        this.transparentSettings = transparentSettings;
        alg = new HairyFlowFieldAlg(transparentSettings);
        final Color primaryColor = Config.palette.getPrimaryColor();
        Color color = new Color(primaryColor.r, primaryColor.g, primaryColor.b, transparentSettings.getAlpha());
        sr.setColor(color);
        for (int i = 0; i < TransparentSettings.settings.getInitFrameSkips(); i++) {
            alg.update();
        }
    }

    @Override
    protected void drawFrame() {
        alg.getDots().forEach(dot -> {
                    sr.setColor(dot.getColor());
                    if (transparentSettings.isConnectedWithStartingPoint())
                        sr.line(dot.getX(), dot.getY(), dot.getInitX(), dot.getInitY());
                    else
                        sr.circle(dot.getX(), dot.getY(), 1);
                }
        );
        alg.update();
    }
}
