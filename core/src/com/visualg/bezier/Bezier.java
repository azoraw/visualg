package com.visualg.bezier;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;

public class Bezier extends ApplicationAdapter {

    private ShapeRenderer sr;
    private OldWidowsScreenSaver oldWidowsScreenSaver;
    private OldWidowsScreenSaver oldWidowsScreenSaver2;

    @Override
    public void create() {

        oldWidowsScreenSaver = new OldWidowsScreenSaver(Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
        oldWidowsScreenSaver2 = new OldWidowsScreenSaver(Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
    }

    @Override
    public void render() {
        refreshCanvas();
        sr.begin(ShapeRenderer.ShapeType.Line);

        for (Pair<Vector2, Vector2> line : oldWidowsScreenSaver.getLines()) {
            sr.line(line.first, line.second);
        }

        for (Pair<Vector2, Vector2> line : oldWidowsScreenSaver2.getLines()) {
            sr.line(line.first, line.second);
        }
        sr.end();
        oldWidowsScreenSaver.update();
        oldWidowsScreenSaver2.update();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
