package com.visualg.animations.transparentRandomWalk;

import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private float transparency = 0.01f;
    private int cellSize = 10;
    private int shapeSize = 40;
    private Shape shape = Shape.RECT;
}
