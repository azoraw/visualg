package com.visualg.animations.transparentRandomWalk;

import com.badlogic.gdx.graphics.Color;
import com.visualg.ui.FrameBufferActor;
import com.visualg.util.color.ColorGenerator;

import static com.visualg.animations.transparentRandomWalk.Settings.INSTANCE;

class TransparentRandomWalkActor extends FrameBufferActor {

    private final Random3DWalkAlg alg;

    public TransparentRandomWalkActor() {
        super(true);
        alg = new Random3DWalkAlg(INSTANCE.getCellSize());
    }

    @Override
    protected void drawFrame() {
        switch (INSTANCE.getShape()) {
            case RECT -> drawRects();
            case CIRCLE -> drawCircles();
            default -> throw new IllegalStateException("Unexpected value: " + INSTANCE.getShape());
        }
        alg.update();

    }

    private void drawRects() {
        final Color color = ColorGenerator.fromHSV(3.6f * alg.getZ(), 1, 1, INSTANCE.getTransparency());
        sr.rect(alg.getX() * INSTANCE.getCellSize(), alg.getY() * INSTANCE.getCellSize(), INSTANCE.getShapeSize(), INSTANCE.getShapeSize(), color, color, color, color);
    }

    private void drawCircles() {
        final Color color = ColorGenerator.fromHSV(3.6f * alg.getZ(), 1, 1, INSTANCE.getTransparency());
        sr.setColor(color);
        sr.circle(alg.getX() * INSTANCE.getCellSize(), alg.getY() * INSTANCE.getCellSize(), INSTANCE.getShapeSize());
    }
}
