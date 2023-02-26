package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.scenes.scene2d.Group;

public class NoiseGroup extends Group {

    public NoiseGroup() {
        Table settingsTable = new Table();
        addActor(new NoiseActor());
        addActor(settingsTable);
    }
}