package com.visualg.animations.fractals.juliaset;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;
import com.visualg.ui.pixmap.PixmapActor;

import static com.visualg.animations.fractals.juliaset.JuliaSetSettings.settings;

public class JuliaSetGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessors;

    public JuliaSetGroup() {
        Table table = new Table(settings);
        PixmapActor pixmapActor = new PixmapActor(new JuliaSetAlg(settings));
        addActor(pixmapActor);
        addActor(table);
        JuliaSetController juliaSetController = new JuliaSetController(settings, table, pixmapActor);
        inputProcessors = new JuliaSetInputProcessor(juliaSetController);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessors;
    }
}
