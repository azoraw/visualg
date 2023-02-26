package com.visualg.animations.transparentRandomWalk;

import com.badlogic.gdx.graphics.Color;
import com.visualg.ui.FrameBufferActor;
import com.visualg.util.color.ColorGenerator;

import static com.visualg.animations.transparentRandomWalk.TransparentRandomWalkSettings.settings;

class TransparentRandomWalkActor extends FrameBufferActor {

    private final Random3DWalkAlg alg;

    public TransparentRandomWalkActor() {
        super(true);
        alg = new Random3DWalkAlg(settings.getCellSize());
    }

    @Override
    protected void drawFrame() {
        switch (settings.getShape()) {
            case RECT -> drawRects();
            case CIRCLE -> drawCircles();
            default -> throw new IllegalStateException("Unexpected value: " + settings.getShape());
        }
        alg.update();

    }

    private void drawRects() {
        final Color color = ColorGenerator.fromHSV(3.6f * alg.getZ(), 1, 1, settings.getTransparency());
        sr.rect(alg.getX() * settings.getCellSize(), alg.getY() * settings.getCellSize(), settings.getShapeSize(), settings.getShapeSize(), color, color, color, color);
    }

    private void drawCircles() {
        final Color color = ColorGenerator.fromHSV(3.6f * alg.getZ(), 1, 1, settings.getTransparency());
        sr.setColor(color);
        sr.circle(alg.getX() * settings.getCellSize(), alg.getY() * settings.getCellSize(), settings.getShapeSize());
    }
}
