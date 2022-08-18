package com.visualg.animations.lines;

import com.visualg.ui.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

public class LinesDoodle extends ShapeRendererActor {

    private final Lines lines;

    public LinesDoodle() {
        super(Line);
        lines = new Lines();
    }

    @Override
    protected void drawFrame() {
        for (LineSegment segment : lines.getSegments()) {
            sr.line(segment.x1, segment.y1, segment.x2, segment.y2);
        }
    }

    @Override
    public void act(float delta) {
        lines.update();
    }
}
