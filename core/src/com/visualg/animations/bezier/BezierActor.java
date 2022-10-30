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
            sr.line(line.pos1(), line.pos2());
        }
        oldWidowsScreenSaver.update();
    }

}
