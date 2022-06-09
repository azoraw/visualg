package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.OpenSimplexNoise;
import com.visualg.util.RandomColorGenerator;
import com.visualg.util.libgdx.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class OpenSimplexDots extends ShapeRendererActor {

    private final OpenSimplexNoise openSimplexNoise;
    private final RandomColorGenerator colorGenerator;
    private int x;

    public OpenSimplexDots() {
        super(Filled);
        openSimplexNoise = new OpenSimplexNoise();
        colorGenerator = new RandomColorGenerator();
        x = 0;
    }

    @Override
    protected void drawFrame() {
        for (int i = 0; i < WIDTH; i++) {
            sr.setColor(new Color(colorGenerator.getRandomColor()));
            sr.circle(i, (HEIGHT / 2) + (float) openSimplexNoise.eval((x + WIDTH * i) * 0.01, 0) * (HEIGHT / 2), 3);
        }
        x++;
    }
}
