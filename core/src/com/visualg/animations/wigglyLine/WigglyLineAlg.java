package com.visualg.animations.wigglyLine;

import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.Pair;
import com.visualg.util.RandomDecorator;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class WigglyLineAlg {

    private final OpenSimplexNoise noise;
    private static final int numberOfPoints = 2500;
    private double magn = 1f;

    WigglyLineAlg() {
        noise = new OpenSimplexNoise(RandomDecorator.Random.nextInt(Integer.MAX_VALUE));
    }

    List<Pair<Integer, Integer>> getVertices() {
        List<Pair<Integer, Integer>> points = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            final float xStep = 0.01f;
            double eval = noise.eval(0, i * xStep);
            final float yStep = 0.03f;
            double eval2 = noise.eval(100, i * yStep);
            final double xDistortion = (eval * 2 - 1) * magn;
            final int x = WIDTH / 4 + (int) ((WIDTH * i / numberOfPoints) + xDistortion) / 2;
            final int y = (int) (magn * eval2 + HEIGHT / 2);
            points.add(new Pair<>(x, y));
        }
        return points;
    }

    void update() {
        magn *= 1.01f;
    }

}
