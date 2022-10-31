package com.visualg.animations.colorPicker;

import com.badlogic.gdx.graphics.Color;
import lombok.Data;

@Data
class Settings {
    static Settings INSTANCE = new Settings();
    private Color chosenColor = Color.BLACK;
}
