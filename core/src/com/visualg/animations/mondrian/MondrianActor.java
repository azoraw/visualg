package com.visualg.animations.mondrian;

import com.badlogic.gdx.graphics.Color;
import com.visualg.ui.FrameBufferActor;

class MondrianActor extends FrameBufferActor {

    private final MondrianAlg alg;
    private Color gradient1;
    private Color gradient2;
    private Color gradient3;
    private Color gradient4;

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
        switch (Settings.INSTANCE.getGradient1()) {
            case BLACK -> gradient1 = Color.BLACK;
            case WHITE -> gradient1 = Color.WHITE;
            case PALETTE -> gradient1 = rect.color();
        }
        switch (Settings.INSTANCE.getGradient2()) {
            case BLACK -> gradient2 = Color.BLACK;
            case WHITE -> gradient2 = Color.WHITE;
            case PALETTE -> gradient2 = rect.color();
        }
        switch (Settings.INSTANCE.getGradient3()) {
            case BLACK -> gradient3 = Color.BLACK;
            case WHITE -> gradient3 = Color.WHITE;
            case PALETTE -> gradient3 = rect.color();
        }
        switch (Settings.INSTANCE.getGradient4()) {
            case BLACK -> gradient4 = Color.BLACK;
            case WHITE -> gradient4 = Color.WHITE;
            case PALETTE -> gradient4 = rect.color();
        }
        sr.rect(rect.x(), rect.y(), rect.width(), rect.height(), gradient1, gradient2, gradient3, gradient4);
    }
}
