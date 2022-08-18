package com.visualg.animations.fractals.mandelbrot;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;
import com.visualg.ui.pixmap.PixmapActor;

public class MandelbrotGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public MandelbrotGroup() {
        Settings settings = Settings.INSTANCE;
        SettingsView settingsView = new SettingsView(settings);
        PixmapActor pixmapActor = new PixmapActor(new MandelbrotSetAlg(settings));
        addActor(pixmapActor);
        addActor(settingsView);
        MandelbrotController mandelbrotController = new MandelbrotController(settings, settingsView, pixmapActor);
        inputProcessors = new MandelbrotInputProcessor(mandelbrotController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
