package com.visualg.lines;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LinesDoodle extends Actor {

    private final ShapeRenderer sr;
    Lines2 lines;

    public LinesDoodle() {
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        lines = new Lines2();
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        for (LineSegment segment : lines.getSegments()) {
            sr.line(segment.x1, segment.y1, segment.x2, segment.y2);
        }
        sr.end();
        lines.update();
    }
}
