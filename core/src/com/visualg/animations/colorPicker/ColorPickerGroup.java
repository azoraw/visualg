package com.visualg.animations.colorPicker;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.controls.InteractiveActor;

public class ColorPickerGroup extends Group implements InteractiveActor {

    private final InputProcessor inputProcessor;

    public ColorPickerGroup() {
        ColorPickerAlg colorPickerAlg = new ColorPickerAlg();
        ColorPickerActor colorPickerActor = new ColorPickerActor(colorPickerAlg);
        addActor(colorPickerActor);
        inputProcessor = new ColorPickerInputProcessor(colorPickerAlg);
    }

    @Override
    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }
}
