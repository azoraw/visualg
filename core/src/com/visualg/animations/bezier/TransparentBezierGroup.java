package com.visualg.animations.bezier;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TransparentBezierGroup extends Group {
    public TransparentBezierGroup() {
        final TransparentBezierActor transparentBezierActor = new TransparentBezierActor();
        addActor(transparentBezierActor);
        final Table table = new Table(transparentBezierActor.onScreenShot());
        addActor(table);

    }
}
