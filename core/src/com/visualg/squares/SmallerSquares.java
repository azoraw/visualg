package com.visualg.squares;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Set;

public class SmallerSquares extends ApplicationAdapter {
    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer sr;
    private Squares squares;


    @Override
    public void create() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        squares = new Squares(WIDTH, HEIGHT);
    }

    @Override
    public void render() {
        refreshCanvas();
        sr.begin(ShapeRenderer.ShapeType.Line);
        Set<Line> lines = squares.getLinesForNumberOfSquares(50);
        for (Line line : lines) {
            sr.line(line.x1, line.y1, line.x2, line.y2);
        }
        sr.end();
        squares.updateAnimationLoop();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
