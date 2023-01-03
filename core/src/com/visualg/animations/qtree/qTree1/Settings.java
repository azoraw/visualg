package com.visualg.animations.qtree.qTree1;

import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private int rectSize = 100;
    private int numberOfParticles = 1000;
}
