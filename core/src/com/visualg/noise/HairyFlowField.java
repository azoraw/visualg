package com.visualg.noise;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.noise.flow.HairyFlowFieldAlg;

public class HairyFlowField extends ApplicationAdapter {

    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private HairyFlowFieldAlg alg;

    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        alg = new HairyFlowFieldAlg(WIDTH, HEIGHT);
    }

    @Override
    public void render() {
        refreshCanvas();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        alg.getDots().forEach(dot ->
                sr.circle(dot.getX(), dot.getY(), 1)
        );
        sr.end();
        alg.update();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
