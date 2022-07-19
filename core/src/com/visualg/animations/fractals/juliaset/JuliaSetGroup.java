package com.visualg.animations.fractals.juliaset;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.util.libgdx.InteractiveActor;

public class JuliaSetGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public JuliaSetGroup() {
        Settings settings = Settings.INSTANCE;
        SettingsView settingsView = new SettingsView(settings);
        addActor(new JuliaSetActor(settings));
        addActor(settingsView);
        JuliaSetController juliaSetController = new JuliaSetController(settings, settingsView);
        inputProcessors = new JuliaSetInputProcessor(juliaSetController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
