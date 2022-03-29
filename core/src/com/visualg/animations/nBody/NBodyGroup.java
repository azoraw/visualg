package com.visualg.animations.nBody;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

public class NBodyGroup extends Group {

    public NBodyGroup() {
        CurrentSettings currentSettings = CurrentSettings.INSTANCE;
        NBodyAlg nBodyAlg = new NBodyAlg(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), currentSettings);
        NBodySettingsTable settings = new NBodySettingsTable(currentSettings);
        this.addActor(new NBodyActor(nBodyAlg));
        this.addActor(settings);
    }
}
