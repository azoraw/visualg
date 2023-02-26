package com.visualg.animations.boids;

import com.badlogic.gdx.scenes.scene2d.Group;

public class BoidsGroup extends Group {
    public BoidsGroup() {
        BoidsSettings boidsSettings = BoidsSettings.settings;
        Table settingsTable = new Table(boidsSettings);
        BoidsActor boidsActor = new BoidsActor(boidsSettings);

        addActor(boidsActor);
        addActor(settingsTable);
    }
}
