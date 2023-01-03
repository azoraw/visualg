package com.visualg.animations.circleStacking;

import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;

import static com.visualg.animations.circleStacking.Settings.INSTANCE;

class CircleStackingActor extends FrameBufferActor {

    private final CircleStackingAlg alg;

    CircleStackingActor() {
        super(true);
        alg = new CircleStackingAlg();
        final Color primaryColor = Config.palette.getPrimaryColor();
        sr.setColor(primaryColor.r, primaryColor.g, primaryColor.b, INSTANCE.getTransparency());
    }

    @Override
    protected void drawFrame() {
        sr.line(alg.getLastCircle().x, alg.getLastCircle().y, alg.getSecondLastCircle().x, alg.getSecondLastCircle().y);
        alg.update();

    }
}
