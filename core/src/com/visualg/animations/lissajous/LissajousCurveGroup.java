package com.visualg.animations.lissajous;

import com.badlogic.gdx.scenes.scene2d.Group;

public class LissajousCurveGroup extends Group {
    public LissajousCurveGroup() {
        addActor(new LissajousCurveActor());
        addActor(new Table());
    }
}
