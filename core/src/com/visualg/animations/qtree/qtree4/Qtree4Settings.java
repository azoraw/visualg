package com.visualg.animations.qtree.qtree4;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Qtree4Settings implements Settings {
    static final Qtree4Settings settings = new Qtree4Settings();

    private int movementSpeed = 1;
    private int rectSize = 100;
    private int numberOfParticles = 1000;
}
