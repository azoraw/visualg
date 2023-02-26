package com.visualg.animations.nBody;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TransparentNBodyGroup extends Group {
    public TransparentNBodyGroup() {
        NBodyAlg nBodyAlg = new NBodyAlg();
        TransparentTable settings = new TransparentTable();
        addActor(new TransparentNBodyActor(nBodyAlg));
        addActor(settings);
    }
}
