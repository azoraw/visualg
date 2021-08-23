package com.visualg.template;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Template extends ApplicationAdapter {
    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;


    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
    }

    @Override
    public void render() {
        refreshCanvas();
        sr.begin(ShapeRenderer.ShapeType.Line);

        sr.end();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
