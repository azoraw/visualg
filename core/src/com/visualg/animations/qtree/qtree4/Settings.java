package com.visualg.animations.qtree.qtree4;

import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private int movementSpeed = 1;
    private int rectSize = 100;
    private int numberOfParticles = 1000;
}
