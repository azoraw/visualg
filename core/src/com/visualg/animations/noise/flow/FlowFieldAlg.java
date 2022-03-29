package com.visualg.animations.noise.flow;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.OpenSimplexNoise;

public class FlowFieldAlg {

    private final int WIDTH;
    private final int HEIGHT;

    private double xStep = 0.05;
    private double yStep = 0.05;
    private double zStep = 0.000001;
    int time = 0;

    public final double scale = 10;

    OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise();
    Vector2[][] vectors;

    public FlowFieldAlg(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        vectors = new Vector2[(WIDTH / (int) scale) + 1][(HEIGHT / (int) scale) + 1];

        for (int x = 0; x < WIDTH / scale; x++) {
            for (int y = 0; y < HEIGHT / scale; y++) {
                vectors[x][y] = new Vector2(1, 0);
                vectors[x][y].setAngleRad((float) (2 * Math.PI * openSimplexNoise.eval(x * xStep, y * yStep, 0)));
            }
        }
    }

    public int getXCoordinate(int x, int y) {
        return (int) (x * scale + scale * Math.cos(vectors[x][y].angleRad()));
    }

    public int getYCoordinate(int x, int y) {
        return (int) (y * scale + scale * Math.sin(vectors[x][y].angleRad()));
    }

    public void update() {
        for (int x = 0; x < WIDTH / scale; x++) {
            for (int y = 0; y < HEIGHT / scale; y++) {
                vectors[x][y].setAngleRad((float) (2 * Math.PI * openSimplexNoise.eval(x * xStep, y * yStep, ++time * zStep)));
            }
        }
    }
}
