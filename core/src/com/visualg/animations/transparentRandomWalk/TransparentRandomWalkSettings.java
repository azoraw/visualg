package com.visualg.animations.transparentRandomWalk;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class TransparentRandomWalkSettings implements Settings {
    static final TransparentRandomWalkSettings settings = new TransparentRandomWalkSettings();

    private float transparency = 0.01f;
    private int cellSize = 10;
    private int shapeSize = 40;
    private Shape shape = Shape.RECT;
}
