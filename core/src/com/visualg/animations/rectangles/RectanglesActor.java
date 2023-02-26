package com.visualg.animations.rectangles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererActor;

import java.util.Set;

public class RectanglesActor extends ShapeRendererActor {

    private final Squares squares;

    public RectanglesActor() {
        super(ShapeRenderer.ShapeType.Line);
        squares = new Squares();
    }


    @Override
    protected void drawFrame() {
        Set<Line> lines = squares.getLinesForNumberOfSquares(50);
        for (Line line : lines) {
            sr.line(line.x1 / 2, Config.HEIGHT - line.y1 / 2, line.x2 / 2, Config.HEIGHT - line.y2 / 2);
            sr.line(Config.WIDTH - line.x1 / 2, Config.HEIGHT - line.y1 / 2, Config.WIDTH - line.x2 / 2, Config.HEIGHT - line.y2 / 2);
            sr.line(line.x1 / 2, line.y1 / 2, line.x2 / 2, line.y2 / 2);
            sr.line(Config.WIDTH - line.x1 / 2, line.y1 / 2, Config.WIDTH - line.x2 / 2, line.y2 / 2);
        }
        squares.updateAnimationLoop();
    }

}
