package com.visualg.animations.lissajous;

import com.visualg.global.Config;
import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class LissajousSettings implements Settings {
    static final LissajousSettings settings = new LissajousSettings();
    private int A = Config.WIDTH / 2;
    private int B = Config.HEIGHT / 2;
    private float PIMultiplierX = 3;
    private float PIMultiplierY = 5;
    private float timeStep = 0.001f;
    private float lineThickness = 2;
    private float transparency = 0.1f;
}
