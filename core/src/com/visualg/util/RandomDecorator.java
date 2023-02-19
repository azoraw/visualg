package com.visualg.util;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDecorator extends java.util.Random {
    public static final RandomDecorator Random = new RandomDecorator();

    public int getIntInRange(int min, int max) {
        return super.nextInt(max - min) + min;
    }

    public  float getFloatInRange(int min, int max) {
        return super.nextFloat(max - min) + min;
    }

    public float getRandomFloat(double max) {
        return super.nextFloat() * (float) max;
    }

    public <E> Optional<E> getRandomElement(Collection<E> collection) {
        return collection
                .stream()
                .skip(ThreadLocalRandom.current()
                        .nextInt(collection.size()))
                .findAny();
    }
}
