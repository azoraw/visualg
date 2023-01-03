package com.visualg.util.color;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.RandomGenerator;

import static com.visualg.util.color.ColorGenerator.fromRGB;

public class Palette {

    public static Color[] MONDRIANS_PALETTE = {fromRGB(38, 71, 124), fromRGB(240, 217, 92),
            fromRGB(162, 45, 40), fromRGB(223, 224, 236), fromRGB(223, 224, 236),
            fromRGB(223, 224, 236), fromRGB(223, 224, 236), fromRGB(223, 224, 236)};
    Color[] palette;

    public Palette(int paletteSize) {
        palette = new Color[paletteSize];
        for (int i = 0; i < paletteSize; i++) {
            palette[i] = new Color(ColorGenerator.getRandomColor());
        }
    }

    public Palette(Color[] palette) {
        this.palette = palette;
    }

    public Color getRandomColor() {
        return palette[RandomGenerator.Random.nextInt(palette.length)];
    }
}
