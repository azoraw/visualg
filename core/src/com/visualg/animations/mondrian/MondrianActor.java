package com.visualg.animations.mondrian;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.libgdx.FrameBufferActor;

class MondrianActor extends FrameBufferActor {

    private final MondrianAlg alg;

    MondrianActor() {
        super(false);
        alg = new MondrianAlg();
    }

    @Override
    protected void drawFrame() {
        for (Rect rectangle : alg.getRectangles()) {
            drawRect(rectangle);
        }
        alg.update();
    }

    private void drawRect(Rect rect) {
        sr.rect(rect.x(), rect.y(), rect.width(), rect.height(), rect.color(), Color.BLACK, rect.color(), Color.WHITE);
    }
}
