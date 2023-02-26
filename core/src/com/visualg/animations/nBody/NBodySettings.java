package com.visualg.animations.nBody;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class NBodySettings implements Settings {
    static NBodySettings settings = new NBodySettings();

    private float g = 5f;
    private int numberOfBodies = 3;
    private float transparency = 0.1f;

}
