package com.visualg.animations.bezier;

import com.visualg.ui.FrameBufferActor;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.animations.bezier.Settings.INSTANCE;

class TransparentBezierActor extends FrameBufferActor {

    private final List<OldWidowsScreenSaver> oldWidowsScreenSavers = new ArrayList<>();

    TransparentBezierActor() {
        super(true);
        for (int i = 0; i < INSTANCE.getNumberOfBlobs(); i++) {
            oldWidowsScreenSavers.add(new OldWidowsScreenSaver(i));
        }
    }

    @Override
    protected void drawFrame() {
        for (int i = 0; i < INSTANCE.getNumberOfBlobs(); i++) {
            final OldWidowsScreenSaver oldWidowsScreenSaver = oldWidowsScreenSavers.get(i);
            for (Line line : oldWidowsScreenSaver.getLines()) {
                sr.line(line.pos1().x, line.pos1().y, line.pos2().x, line.pos2().y, line.colorPair().first(), line.colorPair().second());
            }
        }
        oldWidowsScreenSavers.forEach(OldWidowsScreenSaver::update);
    }


}
