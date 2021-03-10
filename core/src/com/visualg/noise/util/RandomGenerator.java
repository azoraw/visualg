package com.visualg.noise.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomGenerator {
    private static final Random random = new Random();

    public static int getIntInRange(int max) {
        return random.nextInt(max);
    }

    public static float getRandomFloat(double max) {
        return random.nextFloat() * (float) max;
    }
}
