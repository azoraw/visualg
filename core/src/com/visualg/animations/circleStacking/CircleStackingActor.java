package com.visualg.animations.circleStacking;

import com.visualg.util.libgdx.FrameBufferActor;

import static com.visualg.animations.circleStacking.CircleStackingSettings.INSTANCE;

class CircleStackingActor extends FrameBufferActor {

    private final CircleStackingAlg alg;

    public CircleStackingActor() {
        super(true);
        alg = new CircleStackingAlg();
        sr.setColor(1, 1, 1, INSTANCE.getTransparency());
    }

    @Override
    protected void drawFrame() {
        sr.line(alg.getLastCircle().x, alg.getLastCircle().y, alg.getSecondLastCircle().x, alg.getSecondLastCircle().y);
        alg.update();

    }
}
