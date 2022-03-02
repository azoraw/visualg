package com.visualg.wigglyCircle;

import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

class WigglyCircleAlg {

    private int MAX_RADIUS = 700;
    private int THRESHOLD_RADIUS = 250;
    private static final int MIN_RADIUS_OFFSET = 300;
    private static final int VERTEX_NUMBER = 1000; //2499 max
    private double NOISE_DELTA = 1;
    private final float xMiddle;
    private final float yMiddle;
    private final CurrentSettings settings;
    private final OpenSimplexNoise noise;


    public WigglyCircleAlg(float xMiddle, float yMiddle, CurrentSettings currentSettings) {
        this.xMiddle = xMiddle;
        this.yMiddle = yMiddle;
        this.settings = currentSettings;
        noise = new OpenSimplexNoise();
    }

    List<Pair<Float, Float>> getVertices() {
        ArrayList<Pair<Float, Float>> points = new ArrayList<>();
        for (float a = 0; a < 2 * Math.PI; a += 2 * Math.PI / VERTEX_NUMBER) {
            double r = MIN_RADIUS_OFFSET + MAX_RADIUS * noise.eval(NOISE_DELTA * cos(a), NOISE_DELTA * sin(a), settings.getZ());

            if (settings.isApplyThreshold()) {
                r = Math.min(r, THRESHOLD_RADIUS);
            }
            float x = (float) (xMiddle + r * cos(a));
            float y = (float) (yMiddle + r * sin(a));
            points.add(new Pair<>(x, y));
        }
        return points;
    }

    void update() {
       // Z+= 0.01;
        settings.incrementZ();
    }

}
