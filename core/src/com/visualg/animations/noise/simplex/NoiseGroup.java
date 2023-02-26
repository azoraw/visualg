package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.scenes.scene2d.Group;

public class NoiseGroup extends Group {

    public NoiseGroup() {
        SimplexSettings simplexSettings = SimplexSettings.settings;
        Table settingsTable = new Table(simplexSettings);
        addActor(new NoiseActor(simplexSettings));
        addActor(settingsTable);
    }
}