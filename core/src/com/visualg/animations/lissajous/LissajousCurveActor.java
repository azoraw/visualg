package com.visualg.animations.lissajous;

import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;

import static com.visualg.animations.lissajous.LissajousSettings.settings;

class LissajousCurveActor extends FrameBufferActor {
    private final LissajousCurveAlg alg;
    private float x;
    private float y;

    public LissajousCurveActor() {
        super(true);
        alg = new LissajousCurveAlg();
        Color color = Config.palette.getPrimaryColor().cpy();
        color.a = settings.getTransparency();
        sr.setColor(color);
        x = Config.WIDTH / 2 + alg.getX();
        y = Config.HEIGHT / 2 + alg.getY();

    }

    @Override
    protected void drawFrame() {
        float newX = Config.WIDTH / 2 + alg.getX();
        float newY = Config.HEIGHT / 2 + alg.getY();
        sr.rectLine(x,y,newX,newY, settings.getLineThickness());
        x=newX;
        y=newY;
        alg.update();

    }
}
