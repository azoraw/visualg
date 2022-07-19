package com.visualg.animations.fractals.juliaset;

import com.badlogic.gdx.scenes.scene2d.Group;

public class JuliaSetGroup extends Group {

    public JuliaSetGroup() {
        Settings settings = Settings.INSTANCE;
        SettingsView settingsView = new SettingsView(settings);
        addActor(new JuliaSetActor(settings));
        addActor(settingsView);
    }
}
