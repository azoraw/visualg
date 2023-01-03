package com.visualg.animations.mondrian;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {

    static final Settings INSTANCE = new Settings();
    static final int RESOLUTION = (int) Math.pow(2, 12);

    private int paletteSize = 3;
    private int sideMaxSplitLength = 80;
    private int space = 3;
    private boolean mondriatsPalette = true;
    private Gradient gradient1 = Gradient.PALETTE;
    private Gradient gradient2 = Gradient.PALETTE;
    private Gradient gradient3 = Gradient.PALETTE;
    private Gradient gradient4 = Gradient.PALETTE;
}
