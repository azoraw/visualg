package com.visualg.noise.random;

import com.badlogic.gdx.graphics.Pixmap;

import java.util.function.Supplier;

public class RandomPixMap {

    private final RandomColorGenerator randomColorGenerator;
    private final Supplier<Integer> colorSupplier;

    public RandomPixMap(RandomColorMode mode) {
        randomColorGenerator = new RandomColorGenerator();
        colorSupplier = getColorMode(mode);
    }

    private Supplier<Integer> getColorMode(RandomColorMode mode) {
        switch (mode) {
            case RANDOM:
                return randomColorGenerator::getRandomColor;
            case RED_SCALE:
                return randomColorGenerator::getRedScaleColor;
            case MONOCHROMATIC:
                return randomColorGenerator::getMonoChromaticColor;
            case GREY_SCALE:
                return randomColorGenerator::getGreyScaleColor;
            default:
                throw new IllegalArgumentException("This color mode is not supported:" + mode);
        }
    }

    public Pixmap generatePixMap(int WIDTH, int HEIGHT) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                pixmap.drawPixel(i, j, colorSupplier.get());
            }
        }
        return pixmap;
    }
}
