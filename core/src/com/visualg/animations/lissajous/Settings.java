package com.visualg.animations.lissajous;

import com.visualg.global.Config;
import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();
    private int A = Config.WIDTH/2;
    private int B = Config.HEIGHT/2 ;
    private float PIMultiplierX = 3;
    private float PIMultiplierY = 5;
    private float timeStep = 0.001f;
    private float lineThickness = 2;
    private float transparency = 0.1f;
}
