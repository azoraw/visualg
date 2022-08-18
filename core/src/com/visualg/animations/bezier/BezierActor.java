package com.visualg.animations.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Pair;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

public class BezierActor extends ShapeRendererActor {

    private final OldWidowsScreenSaver oldWidowsScreenSaver;

    public BezierActor() {
        super(Line);
        oldWidowsScreenSaver = new OldWidowsScreenSaver();
    }

    @Override
    protected void drawFrame() {
        for (Pair<Vector2, Vector2> line : oldWidowsScreenSaver.getLines()) {
            sr.line(line.first(), line.second());
        }
        oldWidowsScreenSaver.update();
    }

}
