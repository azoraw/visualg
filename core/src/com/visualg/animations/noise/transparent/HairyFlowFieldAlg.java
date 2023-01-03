package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static java.lang.Math.PI;

class HairyFlowFieldAlg {

    private final double xOffset;
    private final double yOffset;

    private final OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise();
    private final Vector2[][] vectors;
    private final Settings settings;

    @Getter
    private List<Dot> dots;

    HairyFlowFieldAlg(Settings settings) {
        settings.restartColor();
        this.settings = settings;
        vectors = new Vector2[WIDTH + 1][HEIGHT + 1];
        xOffset = RandomGenerator.getRandomFloat(10000);
        yOffset = RandomGenerator.getRandomFloat(10000);
        initVectors(WIDTH, HEIGHT);
        initDots();
    }

    private void initDots() {
        dots = new ArrayList<>();
        for (int i = 0; i < settings.getNumberOfAgents(); i++) {
            dots.add(new Dot());
        }
    }

    private void initVectors(int WIDTH, int HEIGHT) {
        for (int x = 0; x <= WIDTH ; x++) {
            for (int y = 0; y <= HEIGHT ; y++) {
                vectors[x][y] = new Vector2(1, 0);
                vectors[x][y].setAngleRad((float)
                        (2 * PI * openSimplexNoise.eval(
                                x * settings.getStep() + xOffset,
                                y * settings.getStep() + yOffset)));
            }
        }
    }

    void update() {
        dots.forEach(dot ->
                dot.moveWithFlow(vectors[dot.getX()][dot.getY()])
        );
    }
}
