package com.visualg.util.color;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.RandomDecorator;

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

    public static int getRandomColor() {
        return RandomDecorator.Random.nextInt();
    }

    public static Color fromRGB(int r, int g, int b) {
        return new Color(Color.rgba8888(r / 256f, g / 256f, b / 256f, 1f));
    }

    public static Color fromHSV(float h, float s, float v) {
        return Color.WHITE.cpy().fromHsv(h, s, v);
    }

    public static Color fromHSV(float h, float s, float v, float transparency) {
        final Color color = Color.WHITE.cpy().fromHsv(h, s, v);
        color.a = transparency;
        return color;
    }

    public int getRedScaleColor() {
        return RandomDecorator.Random.nextInt() & redMask;
    }

    public int getMonoChromaticColor() {
        return RandomDecorator.Random.nextInt() | monochromaticMask;
    }

    public int getGreyScaleColor() {
        int luminosity = RandomDecorator.Random.nextInt() & alphaMask;
        int tmp = luminosity << 8;
        tmp = luminosity ^ tmp;
        return (tmp << 16) ^ tmp;
    }

}
