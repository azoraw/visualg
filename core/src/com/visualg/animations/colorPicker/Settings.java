package com.visualg.animations.colorPicker;

import com.badlogic.gdx.graphics.Color;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {
    static Settings INSTANCE = new Settings();
    private Color chosenColor = Color.BLACK;
}
