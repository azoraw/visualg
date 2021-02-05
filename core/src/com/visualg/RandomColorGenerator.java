package com.visualg;

import java.util.Random;

/**
 * Generates RGBA8888
 * RGBA8888 format: RRRRRRRRGGGGGGGGBBBBBBBBAAAAAAAAA
 * R - Red
 * G - Green
 * B - Blue
 * A - Alpha
 */
class RandomColorGenerator {

    private static final int monochromaticMask = 0B11111111111111111111111100000000;
    private static final int redMask = 0B11111111000000000000000011111111;
    private static final int alphaMask = 0B00000000000000000000000011111111;

    private final Random random = new Random();

    int getRandomColor() {
        return random.nextInt();
    }

    int getRedScaleColor() {
        return random.nextInt() & redMask;
    }

    int getMonoChromaticColor() {
        return random.nextInt() | monochromaticMask;
    }

    int getGreyScaleColor() {
        int luminosity = random.nextInt() & alphaMask;
        int tmp = luminosity << 8;
        tmp = luminosity ^ tmp;
        return (tmp << 16) ^ tmp;
    }
}
