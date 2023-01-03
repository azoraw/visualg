package com.visualg.animations.fractals.mandelbrot;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;
import com.visualg.ui.pixmap.PixmapActor;

public class MandelbrotGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public MandelbrotGroup() {
        Settings settings = Settings.INSTANCE;
        Table table = new Table(settings);
        PixmapActor pixmapActor = new PixmapActor(new MandelbrotSetAlg(settings));
        addActor(pixmapActor);
        addActor(table);
        MandelbrotController mandelbrotController = new MandelbrotController(settings, table, pixmapActor);
        inputProcessors = new MandelbrotInputProcessor(mandelbrotController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
