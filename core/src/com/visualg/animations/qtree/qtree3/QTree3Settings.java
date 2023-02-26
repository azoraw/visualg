package com.visualg.animations.qtree.qtree3;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class QTree3Settings implements Settings {
    static final QTree3Settings settings = new QTree3Settings();

    private int movementSpeed = 5;
    private int rectSize = 200;
    private int numberOfParticles = 1000;
}
