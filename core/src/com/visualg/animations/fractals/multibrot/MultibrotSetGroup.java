package com.visualg.animations.fractals.multibrot;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.util.libgdx.InteractiveActor;
import com.visualg.util.libgdx.PixmapActor;

public class MultibrotSetGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public MultibrotSetGroup() {
        Settings settings = Settings.INSTANCE;
        SettingsView settingsView = new SettingsView(settings);
        PixmapActor pixmapActor = new PixmapActor(new MultibrotAlg(settings));
        addActor(pixmapActor);
        addActor(settingsView);
        MultibrotSetController multibrotSetController = new MultibrotSetController(settings, settingsView, pixmapActor);
        inputProcessors = new MultibrotSetInputProcessor(multibrotSetController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
