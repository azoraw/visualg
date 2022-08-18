package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class HairyFlowFieldAlg {

    private final double xOffset;
    private final double yOffset;

    private final OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise();
    private final Vector2[][] vectors;
    private final CurrentSettings settings;

    @Getter
    private List<Dot> dots;

    HairyFlowFieldAlg(CurrentSettings settings) {
        this.settings = settings;
        vectors = new Vector2[(WIDTH / settings.getScale()) + 1][(HEIGHT / settings.getScale()) + 1];
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
        for (int x = 0; x <= WIDTH / settings.getScale(); x++) {
            for (int y = 0; y <= HEIGHT / settings.getScale(); y++) {
                vectors[x][y] = new Vector2(1, 0);
                vectors[x][y].setAngleRad((float) (2 * Math.PI * openSimplexNoise.eval(x * settings.getXStep() + xOffset,
                        y * settings.getYStep() + yOffset)));
            }
        }
    }

    void update() {
        dots.forEach(dot ->
                dot.moveWithFlow(vectors[dot.getX() / settings.getScale()][dot.getY() / settings.getScale()])
        );
    }
}
