package com.visualg.animations.rectangles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Set;

public class Rectangles extends Actor {

    private final ShapeRenderer sr;
    private final Squares squares;

    public Rectangles() {
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        squares = new Squares();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        Set<Line> lines = squares.getLinesForNumberOfSquares(50);
        for (Line line : lines) {
            sr.line(line.x1, line.y1, line.x2, line.y2);
        }
        sr.end();
        squares.updateAnimationLoop();
        batch.begin();
    }

}
