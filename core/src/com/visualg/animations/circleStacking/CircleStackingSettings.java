package com.visualg.animations.circleStacking;

import com.visualg.util.MutablePair;
import com.visualg.util.RandomGenerator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.util.RandomGenerator.getIntInRange;

@Data
class CircleStackingSettings {
    static final CircleStackingSettings INSTANCE;

    static {
        INSTANCE = new CircleStackingSettings();
        INSTANCE.setNumberOfCircles(3);
    }

    private int numberOfCircles = 3;
    private List<MutablePair<Integer, Integer>> circles = new ArrayList<>();
    private float transparency = 0.008f;

    public void setNumberOfCircles(int numberOfCircles) {
        this.numberOfCircles = numberOfCircles;
        circles.clear();
        for (int i = 0; i < numberOfCircles; i++) {
            circles.add(new MutablePair<>(125, 1000));
        }
    }

    public void randomise() {
        numberOfCircles = getIntInRange(2, 5);
        circles.clear();
        for (int i = 0; i < numberOfCircles; i++) {
            circles.add(new MutablePair<>(RandomGenerator.getIntInRange(500), getIntInRange(10000)));
        }
    }

}
