package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.RandomDecorator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

class HairyFlowFieldAlg {

    private final OpenSimplexNoise openSimplexNoise = new OpenSimplexNoise(RandomDecorator.Random.nextInt());
    private final Vector2[][] vectors;
    private final Settings settings;

    @Getter
    private List<Dot> dots;

    HairyFlowFieldAlg(Settings settings) {
        settings.restartColor();
        this.settings = settings;
        vectors = new Vector2[WIDTH + 1][HEIGHT + 1];
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
        for (int x = 0; x <= WIDTH; x++) {
            for (int y = 0; y <= HEIGHT; y++) {
                vectors[x][y] = new Vector2(1, 0);
                double eval;
                if (settings.isHaveMiddleCircle() && isInsideCircle(x,y)) {
                    eval = openSimplexNoise.eval(
                            x * settings.getStep() / 100,
                            y * settings.getStep() / 100);
                } else {
                    eval = openSimplexNoise.eval(
                            x * settings.getStep(),
                            y * settings.getStep());
                }
                vectors[x][y].setAngleRad((float) (2 * PI * eval));
            }
        }
    }

    private boolean isInsideCircle(int x, int y) {
        float r = 0.75f * HEIGHT / 2;
        int xNorm = x - WIDTH / 2;
        int yNorm = y - HEIGHT / 2;

        return sqrt(xNorm * xNorm + yNorm * yNorm) < r;
    }

    void update() {
        dots.forEach(dot ->
                dot.moveWithFlow(vectors[dot.getX()][dot.getY()])
        );
    }
}
