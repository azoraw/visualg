package com.visualg.animations.boids;

import com.badlogic.gdx.scenes.scene2d.Group;

public class BoidsGroup extends Group {
    public BoidsGroup() {
        Settings settings = Settings.INSTANCE;
        Table settingsTable = new Table(settings);
        BoidsActor boidsActor = new BoidsActor(settings);

        addActor(boidsActor);
        addActor(settingsTable);
    }
}
