package com.visualg.animations.nBody;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class NBodySettings implements Settings {
    static NBodySettings settings = new NBodySettings();

    private float g = 1f;
    private int numberOfBodies = 100;
    private float visibilityRadius = 300;
    private float transparency = 0.1f;

}
