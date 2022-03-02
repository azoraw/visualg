package com.visualg.noise;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.noise.random.RandomColorGenerator;
import com.visualg.util.OpenSimplexNoise;

public class OpenSimplexDots extends ApplicationAdapter {

    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private OpenSimplexNoise openSimplexNoise;
    private RandomColorGenerator colorGenerator;
    private int x;

    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        openSimplexNoise = new OpenSimplexNoise();
        sr = new ShapeRenderer();
        colorGenerator = new RandomColorGenerator();
        x = 0;
    }

    @Override
    public void render() {
        refreshCanvas();

        sr.begin(ShapeRenderer.ShapeType.Filled);
            for (int i = 0; i < WIDTH; i++) {
                sr.setColor(new Color(colorGenerator.getRandomColor()));
                sr.circle(i, (HEIGHT / 2) + (float) openSimplexNoise.eval((x + WIDTH * i) * 0.01, 0) * (HEIGHT / 2), 3);
            }
        x++;
        sr.end();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
