package com.visualg.animations.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;
import com.visualg.util.libgdx.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

public class Bezier extends ShapeRendererActor {

    private final OldWidowsScreenSaver oldWidowsScreenSaver;

    public Bezier() {
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
