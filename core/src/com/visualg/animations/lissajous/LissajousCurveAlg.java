package com.visualg.animations.lissajous;

import static com.visualg.animations.lissajous.LissajousSettings.settings;

class LissajousCurveAlg {

    // x =  acos(kt)
    //y =  bsin(kt)
    private float t = 0;

    void update() {
        t += settings.getTimeStep();
    }

    float getX() {
        return settings.getA() * (float) Math.cos(Math.PI * settings.getPIMultiplierX() * t);
    }

    float getY() {
        return settings.getB() * (float) Math.sin(Math.PI * settings.getPIMultiplierY() * t);
    }
}
