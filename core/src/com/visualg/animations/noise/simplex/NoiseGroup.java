package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.scenes.scene2d.Group;

public class NoiseGroup extends Group {

    public NoiseGroup() {
        NoiseSettings settings = NoiseSettings.INSTANCE;
        NoiseSettingsTable settingsTable = new NoiseSettingsTable(settings);
        addActor(new NoiseActor(settings));
        addActor(settingsTable);
    }
}