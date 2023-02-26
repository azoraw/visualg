package com.visualg.animations.qtree.qtree3;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Qtree3Settings implements Settings {
    static final Qtree3Settings settings = new Qtree3Settings();

    private int movementSpeed = 1;
    private int rectSize = 100;
    private int numberOfParticles = 1000;
}
