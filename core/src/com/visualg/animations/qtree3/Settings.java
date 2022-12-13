package com.visualg.animations.qtree3;

import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private int movementSpeed = 5;
    private int rectSize = 200;
    private int numberOfParticles = 1000;
}
