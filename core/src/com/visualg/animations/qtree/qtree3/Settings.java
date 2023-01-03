package com.visualg.animations.qtree.qtree3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private int movementSpeed = 5;
    private int rectSize = 200;
    private int numberOfParticles = 1000;
}
