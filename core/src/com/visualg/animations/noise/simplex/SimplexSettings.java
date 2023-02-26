package com.visualg.animations.noise.simplex;


import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class SimplexSettings implements Settings {

    static final SimplexSettings settings = new SimplexSettings();

    private int numberOfSkippedPixels = 10;
    private SimplexColorMode colorMode = SimplexColorMode.GRAYSCALE;
    private double X_OFF = 0.1;
    private double Y_OFF = 0.1;
    private double Z_OFF = 0.04;

    void changeColorMode() {
        if (colorMode == SimplexColorMode.GRAYSCALE) {
            colorMode = SimplexColorMode.BLACK_AND_WHITE;
        } else
            colorMode = SimplexColorMode.GRAYSCALE;
    }
}
