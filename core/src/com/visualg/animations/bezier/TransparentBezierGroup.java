package com.visualg.animations.bezier;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TransparentBezierGroup extends Group {
    public TransparentBezierGroup() {
        final TransparentBezierActor transparentBezierActor = new TransparentBezierActor();
        addActor(transparentBezierActor);
        final TransparentBezierSettings transparentBezierSettings = new TransparentBezierSettings(transparentBezierActor.onScreenShot());
        addActor(transparentBezierSettings);

    }
}
