package com.visualg.animations.kandynsky;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;

public class KandynskyGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessor;

    public KandynskyGroup() {
        final KandynskyAlg alg = new KandynskyAlg();
        final KandynskyActor kandynskyActor = new KandynskyActor(alg);
        addActor(kandynskyActor);
        final Table table = new Table(alg);
        addActor(table);
        inputProcessor = new CreateInputController(alg, table);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }
}
