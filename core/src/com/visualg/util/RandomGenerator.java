package com.visualg.util;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    public static int nextInt() {
        return random.nextInt();
    }

    public static int nextInt(int max) {
        return random.nextInt(max);
    }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    public static <E> Optional<E> getRandomElement(Collection<E> collection) {
        return collection
                .stream()
                .skip(ThreadLocalRandom.current()
                        .nextInt(collection.size()))
                .findAny();
    }
}
