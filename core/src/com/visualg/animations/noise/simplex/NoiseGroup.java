package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.scenes.scene2d.Group;

public class NoiseGroup extends Group {

    public NoiseGroup() {
        Settings settings = Settings.INSTANCE;
        Table settingsTable = new Table(settings);
        addActor(new NoiseActor(settings));
        addActor(settingsTable);
    }
}