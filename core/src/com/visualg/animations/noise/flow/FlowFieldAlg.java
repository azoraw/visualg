package com.visualg.animations.noise.flow;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.OpenSimplexNoise;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class FlowFieldAlg {

    private final double xStep = 0.05;
    private final double yStep = 0.05;
    private final double zStep = 0.000001;
    int time = 0;

    final double scale = 10;

    OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise();
    Vector2[][] vectors;

    FlowFieldAlg() {
        vectors = new Vector2[(WIDTH / (int) scale) + 1][(HEIGHT / (int) scale) + 1];

        for (int x = 0; x < WIDTH / scale; x++) {
            for (int y = 0; y < HEIGHT / scale; y++) {
                vectors[x][y] = new Vector2(1, 0);
                vectors[x][y].setAngleRad((float) (2 * Math.PI * openSimplexNoise.eval(x * xStep, y * yStep, 0)));
            }
        }
    }

    int getXCoordinate(int x, int y) {
        return (int) (x * scale + scale * Math.cos(vectors[x][y].angleRad()));
    }

    int getYCoordinate(int x, int y) {
        return (int) (y * scale + scale * Math.sin(vectors[x][y].angleRad()));
    }

    void update() {
        for (int x = 0; x < WIDTH / scale; x++) {
            for (int y = 0; y < HEIGHT / scale; y++) {
                vectors[x][y].setAngleRad((float) (2 * Math.PI * openSimplexNoise.eval(x * xStep, y * yStep, ++time * zStep)));
            }
        }
    }
}
