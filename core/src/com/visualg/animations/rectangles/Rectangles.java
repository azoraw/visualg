package com.visualg.animations.rectangles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.ui.ShapeRendererActor;

import java.util.Set;

public class Rectangles extends ShapeRendererActor {

    private final Squares squares;

    public Rectangles() {
        super(ShapeRenderer.ShapeType.Line);
        squares = new Squares();
    }


    @Override
    protected void drawFrame() {
        Set<Line> lines = squares.getLinesForNumberOfSquares(50);
        for (Line line : lines) {
            sr.line(line.x1, line.y1, line.x2, line.y2);
        }
        squares.updateAnimationLoop();
    }

}
