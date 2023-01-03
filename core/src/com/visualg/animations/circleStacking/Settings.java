package com.visualg.animations.circleStacking;

import com.visualg.util.MutablePair;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.util.RandomGenerator.Random;
import static com.visualg.util.RandomGenerator.getIntInRange;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {
    static final Settings INSTANCE;

    static {
        INSTANCE = new Settings();
        INSTANCE.setNumberOfCircles(3);
    }

    private int numberOfCircles = 3;
    private List<MutablePair<Integer, Integer>> circles = new ArrayList<>();
    private float transparency = 0.008f;

    void setNumberOfCircles(int numberOfCircles) {
        this.numberOfCircles = numberOfCircles;
        circles.clear();
        for (int i = 0; i < numberOfCircles; i++) {
            circles.add(new MutablePair<>(125, 1000));
        }
    }

    void randomise() {
        numberOfCircles = getIntInRange(2, 5);
        circles.clear();
        for (int i = 0; i < numberOfCircles; i++) {
            circles.add(new MutablePair<>(Random.nextInt(500), Random.nextInt(10000)));
        }
    }

}
