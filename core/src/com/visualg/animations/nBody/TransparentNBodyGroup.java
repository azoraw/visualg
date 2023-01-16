package com.visualg.animations.nBody;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TransparentNBodyGroup extends Group {
    public TransparentNBodyGroup() {
        CurrentSettings currentSettings = CurrentSettings.INSTANCE;
        NBodyAlg nBodyAlg = new NBodyAlg(currentSettings);
        TransparentTable settings = new TransparentTable(currentSettings);
        addActor(new TransparentNBodyActor(nBodyAlg));
        addActor(settings);
    }
}
