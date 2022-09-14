package com.visualg.animations.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.ui.FrameBufferActor;
import com.visualg.util.Pair;

public class TransparentBezierActor extends FrameBufferActor {

    private final OldWidowsScreenSaver oldWidowsScreenSaver;

    public TransparentBezierActor() {
        super(true);
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
