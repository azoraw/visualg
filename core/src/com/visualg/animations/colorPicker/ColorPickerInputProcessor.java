package com.visualg.animations.colorPicker;

import com.visualg.ui.simplifiedComponents.DefaultInputProcessor;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;

@RequiredArgsConstructor
class ColorPickerInputProcessor implements DefaultInputProcessor {

    private final ColorPickerAlg colorPickerAlg;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        colorPickerAlg.touch(screenX, HEIGHT - screenY);
        return true;
    }
}
