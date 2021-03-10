package com.visualg.noise.flow;

import com.badlogic.gdx.math.Vector2;
import com.visualg.noise.simplex.OpenSimplexNoise;
import com.visualg.noise.util.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class HairyFlowFieldAlg {

    private final int WIDTH;
    private final int HEIGHT;

    private final double xStep = 0.05;
    private final double yStep = 0.05;
    private final double xOffset;
    private final double yOffset;

    public final double scale = 10;
    private final OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise();
    private final Vector2[][] vectors;

    @Getter
    private List<Dot> dots;

    public HairyFlowFieldAlg(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        vectors = new Vector2[(WIDTH / (int) scale) + 1][(HEIGHT / (int) scale) + 1];
        xOffset = RandomGenerator.getRandomFloat(10000);
        yOffset = RandomGenerator.getRandomFloat(10000);
        initVectors(WIDTH, HEIGHT);
        initDots();
    }

    private void initDots() {
        dots = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dots.add(new Dot(WIDTH, HEIGHT));
        }
    }

    private void initVectors(int WIDTH, int HEIGHT) {
        for (int x = 0; x <= WIDTH / scale; x++) {
            for (int y = 0; y <= HEIGHT / scale; y++) {
                vectors[x][y] = new Vector2(1, 0);
                vectors[x][y].setAngleRad((float) (2 * Math.PI * openSimplexNoise.eval(x * xStep + xOffset, y * yStep + yOffset)));
            }
        }
    }

    public void update() {
        dots.forEach(dot ->
                dot.moveWithFlow(vectors[dot.getX() / (int) scale][dot.getY() / (int) scale])
        );
    }
}
