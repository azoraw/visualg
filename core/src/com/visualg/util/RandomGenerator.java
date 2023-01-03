package com.visualg.util;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator extends Random {
    public static final RandomGenerator Random = new RandomGenerator();
    
    public static int getIntInRange(int min, int max) {
        return Random.nextInt(max - min) + min;
    }

    public static float getFloatInRange(int min, int max) {
        return Random.nextFloat(max - min) + min;
    }

    public static float getRandomFloat(double max) {
        return Random.nextFloat() * (float) max;
    }

    public static <E> Optional<E> getRandomElement(Collection<E> collection) {
        return collection
                .stream()
                .skip(ThreadLocalRandom.current()
                        .nextInt(collection.size()))
                .findAny();
    }
}
