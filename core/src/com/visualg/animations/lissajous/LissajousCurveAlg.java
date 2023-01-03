package com.visualg.animations.lissajous;

import static com.visualg.animations.lissajous.Settings.INSTANCE;

class LissajousCurveAlg {

    // x =  acos(kt)
    //y =  bsin(kt)
    private float t = 0;

    void update() {
        t += INSTANCE.getTimeStep();
    }

    float getX() {
        return INSTANCE.getA() * (float) Math.cos(Math.PI * INSTANCE.getPIMultiplierX() * t);
    }

    float getY() {
        return INSTANCE.getB() * (float) Math.sin(Math.PI * INSTANCE.getPIMultiplierY() * t);
    }
}
