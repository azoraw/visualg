package com.visualg.util.color;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.RandomGenerator;

/**
 * Generates RGBA8888
 * RGBA8888 format: RRRRRRRRGGGGGGGGBBBBBBBBAAAAAAAAA
 * R - Red
 * G - Green
 * B - Blue
 * A - Alpha
 */
public class ColorGenerator {

    private static final int monochromaticMask = 0B11111111111111111111111100000000;
    private static final int redMask = 0B11111111000000000000000011111111;
    private static final int alphaMask = 0B00000000000000000000000011111111;

    public int getRandomColor() {
        return RandomGenerator.nextInt();
    }

    public int getRedScaleColor() {
        return RandomGenerator.nextInt() & redMask;
    }

    public int getMonoChromaticColor() {
        return RandomGenerator.nextInt() | monochromaticMask;
    }

    public int getGreyScaleColor() {
        int luminosity = RandomGenerator.nextInt() & alphaMask;
        int tmp = luminosity << 8;
        tmp = luminosity ^ tmp;
        return (tmp << 16) ^ tmp;
    }

    public static Color fromRGB(int r, int g, int b) {
        return new Color(Color.rgba8888((float) r/256, (float)g/256, (float) b/256,1f));
    }

    public static Color fromHSV(float h, float s, float v) {
        return new Color().set(Color.WHITE).fromHsv(h, s, v);
    }

}
