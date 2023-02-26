package com.visualg.animations.boids;

import com.badlogic.gdx.scenes.scene2d.Group;

import static com.visualg.animations.boids.BoidsSettings.settings;

public class BoidsGroup extends Group {
    public BoidsGroup() {
        BoidsSettings boidsSettings = settings;
        Table settingsTable = new Table(boidsSettings);
        BoidsActor boidsActor = new BoidsActor(boidsSettings);

        addActor(boidsActor);
        addActor(settingsTable);
    }
}
