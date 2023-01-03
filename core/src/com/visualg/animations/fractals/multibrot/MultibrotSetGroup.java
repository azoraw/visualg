package com.visualg.animations.fractals.multibrot;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;
import com.visualg.ui.pixmap.PixmapActor;

public class MultibrotSetGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public MultibrotSetGroup() {
        Settings settings = Settings.INSTANCE;
        Table table = new Table(settings);
        PixmapActor pixmapActor = new PixmapActor(new MultibrotAlg(settings));
        addActor(pixmapActor);
        addActor(table);
        MultibrotSetController multibrotSetController = new MultibrotSetController(settings, table, pixmapActor);
        inputProcessors = new MultibrotSetInputProcessor(multibrotSetController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
