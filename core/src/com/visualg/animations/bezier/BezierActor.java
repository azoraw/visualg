package com.visualg.animations.bezier;

import com.visualg.ui.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

public class BezierActor extends ShapeRendererActor {

    private final OldWidowsScreenSaver oldWidowsScreenSaver;

    public BezierActor() {
        super(Line);
        oldWidowsScreenSaver = new OldWidowsScreenSaver(0);
    }

    @Override
    protected void drawFrame() {
        for (Line line : oldWidowsScreenSaver.getLines()) {
            sr.line(line.end1().x, line.end1().y, line.end2().x, line.end2().y, line.colorPair().first(), line.colorPair().second());
        }
        oldWidowsScreenSaver.update();
    }

}
