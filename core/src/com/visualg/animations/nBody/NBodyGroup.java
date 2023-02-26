package com.visualg.animations.nBody;

import com.badlogic.gdx.scenes.scene2d.Group;

public class NBodyGroup extends Group {

    public NBodyGroup() {
        NBodyAlg nBodyAlg = new NBodyAlg();
        Table settings = new Table();
        addActor(new NBodyActor(nBodyAlg));
        addActor(settings);
    }
}
