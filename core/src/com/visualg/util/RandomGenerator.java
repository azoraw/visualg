package com.visualg.util;

import com.badlogic.gdx.graphics.Color;
import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomGenerator {
    private static final Random random = new Random();

    public static int getIntInRange(int max) {
        return random.nextInt(max);
    }

    public static int getIntInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static float getRandomFloat(double max) {
        return random.nextFloat() * (float) max;
    }

    public static Color getRandomColor() {
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1);
    }
}
