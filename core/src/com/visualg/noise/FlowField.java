package com.visualg.noise;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.noise.flow.FlowFieldAlg;

public class FlowField extends ApplicationAdapter {

    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private FlowFieldAlg alg;

    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        alg = new FlowFieldAlg(WIDTH, HEIGHT);
    }

    @Override
    public void render() {
        refreshCanvas();
        sr.begin(ShapeRenderer.ShapeType.Line);
        for (int x = 0; x < WIDTH / alg.scale; x++) {
            for (int y = 0; y < HEIGHT / alg.scale; y++) {
                sr.line(x * (int) alg.scale, y * (int) alg.scale, alg.getXCoordinate(x, y), alg.getYCoordinate(x, y));
            }
        }
        sr.end();
        alg.update();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
