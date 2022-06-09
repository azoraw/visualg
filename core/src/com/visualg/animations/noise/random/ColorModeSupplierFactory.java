package com.visualg.animations.noise.random;

import com.visualg.util.RandomColorGenerator;

import java.util.function.Supplier;

public class ColorModeSupplierFactory {

    static Supplier<Integer> getColorMode(RandomColorMode mode, RandomColorGenerator randomColorGenerator) {
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
}
