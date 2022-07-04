package com.visualg.animations.boids;

import com.badlogic.gdx.scenes.scene2d.Group;

public class BoidsGroup extends Group {
    public BoidsGroup() {
        BoidsSettings settings = BoidsSettings.INSTANCE;
        BoidsSettingsTable settingsTable = new BoidsSettingsTable(settings);
        BoidsActor boidsActor = new BoidsActor(settings);

        this.addActor(boidsActor);
        this.addActor(settingsTable);
    }
}
