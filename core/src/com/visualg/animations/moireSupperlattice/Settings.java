package com.visualg.animations.moireSupperlattice;

import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();
    private float transparency = 0.5f;
    private int moduloX = 10;
    private int moduloY = 10;
    private float rotationSpeed = 0.1f;
    private ColorOption colorOption = ColorOption.PRIMARY;
    private ColorOption colorOption2 = ColorOption.PRIMARY;
}
