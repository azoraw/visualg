package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.noise.random.RandomColorGenerator;
import com.visualg.util.OpenSimplexNoise;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class OpenSimplexDots extends Actor {

    private ShapeRenderer sr;
    private OpenSimplexNoise openSimplexNoise;
    private RandomColorGenerator colorGenerator;
    private int x;

    public OpenSimplexDots() {
        openSimplexNoise = new OpenSimplexNoise();
        sr = new ShapeRenderer();
        colorGenerator = new RandomColorGenerator();
        x = 0;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < WIDTH; i++) {
            sr.setColor(new Color(colorGenerator.getRandomColor()));
            sr.circle(i, (HEIGHT / 2) + (float) openSimplexNoise.eval((x + WIDTH * i) * 0.01, 0) * (HEIGHT / 2), 3);
        }
        x++;
        sr.end();
        batch.begin();
    }

}
