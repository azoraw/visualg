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
    private Color color = new Color(1,1,1,0.02f);

    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(color);
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
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

}
