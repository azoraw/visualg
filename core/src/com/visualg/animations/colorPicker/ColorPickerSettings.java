package com.visualg.animations.colorPicker;

import com.badlogic.gdx.graphics.Color;
import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class ColorPickerSettings implements Settings {
    static final ColorPickerSettings settings = new ColorPickerSettings();
    private Color chosenColor = Color.BLACK;
}
