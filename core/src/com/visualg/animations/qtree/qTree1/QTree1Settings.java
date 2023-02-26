package com.visualg.animations.qtree.qTree1;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class QTree1Settings implements Settings {
    static final QTree1Settings settings = new QTree1Settings();

    private int rectSize = 100;
    private int numberOfParticles = 1000;
    private QueryMode mode = QueryMode.RECT;
}
