package com.visualg.animations.wigglyCircle;

import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

class WigglyCircleAlg {

    private final int THRESHOLD_RADIUS = 250;

    private final float xMiddle;
    private final float yMiddle;
    private final WigglyCircleSettings wigglyCircleSettings;
    private final OpenSimplexNoise noise;


    WigglyCircleAlg(float xMiddle, float yMiddle, WigglyCircleSettings wigglyCircleSettings) {
        this.xMiddle = xMiddle;
        this.yMiddle = yMiddle;
        this.wigglyCircleSettings = wigglyCircleSettings;
        noise = new OpenSimplexNoise();
    }

    List<Pair<Float, Float>> getVertices() {
        ArrayList<Pair<Float, Float>> points = new ArrayList<>();
        for (float a = 0; a < 2 * Math.PI; a += 2 * Math.PI / wigglyCircleSettings.getVertexNumber()) {
            double r = wigglyCircleSettings.getStartingRadius() + wigglyCircleSettings.getMaxRadius() * noise.eval(wigglyCircleSettings.getNoiseDeltaX() * cos(a), wigglyCircleSettings.getNoiseDeltaY() * sin(a), wigglyCircleSettings.getZ());
            if (wigglyCircleSettings.isThresholdEnabled()) {
                r = Math.min(r, THRESHOLD_RADIUS);
            }
            float x = (float) (xMiddle + r * cos(a));
            float y = (float) (yMiddle + r * sin(a));
            points.add(new Pair<>(x, y));
        }
        return points;
    }

    void update() {
        wigglyCircleSettings.incrementZ();
    }

}
