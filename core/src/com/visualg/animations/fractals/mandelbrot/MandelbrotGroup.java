package com.visualg.animations.fractals.mandelbrot;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;
import com.visualg.ui.pixmap.PixmapActor;

public class MandelbrotGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public MandelbrotGroup() {
        MandelbrotSettings mandelbrotSettings = MandelbrotSettings.INSTANCE;
        Table table = new Table(mandelbrotSettings);
        PixmapActor pixmapActor = new PixmapActor(new MandelbrotSetAlg(mandelbrotSettings));
        addActor(pixmapActor);
        addActor(table);
        MandelbrotController mandelbrotController = new MandelbrotController(mandelbrotSettings, table, pixmapActor);
        inputProcessors = new MandelbrotInputProcessor(mandelbrotController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
