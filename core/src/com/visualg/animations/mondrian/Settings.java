package com.visualg.animations.mondrian;

import lombok.Data;

@Data
class Settings {

    static final Settings INSTANCE = new Settings();
    static final int RESOLUTION = (int) Math.pow(2, 11);

    private int paletteSize = 3;
    private int sideMaxSplitLength = 80;
    private int space = 3;
    private boolean mondriatsPalette = true;
}
