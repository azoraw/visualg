package com.visualg.animations.qtree.qtree2;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class QTree2Settings implements Settings {
    static final QTree2Settings settings = new QTree2Settings();

    private int movementSpeed = 5;
    private int rectSize = 200;
    private int numberOfParticles = 1000;
}
