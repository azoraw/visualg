package com.visualg.animations.circleStacking;

import com.visualg.ui.settings.Settings;
import com.visualg.util.MutablePair;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.util.RandomDecorator.Random;

@Data
class CircleStackingSettings implements Settings {
    static final CircleStackingSettings settings = new CircleStackingSettings();

    private int numberOfCircles = 3;
    private List<MutablePair<Integer, Integer>> circles = new ArrayList<>();
    private float transparency = 0.008f;

    private CircleStackingSettings() {
        setNumberOfCircles(numberOfCircles);
    }

    void setNumberOfCircles(int numberOfCircles) {
        this.numberOfCircles = numberOfCircles;
        circles.clear();
        for (int i = 0; i < numberOfCircles; i++) {
            circles.add(new MutablePair<>(125, 1000));
        }
    }

    void randomise() {
        numberOfCircles = Random.getIntInRange(2, 5);
        circles.clear();
        for (int i = 0; i < numberOfCircles; i++) {
            circles.add(new MutablePair<>(Random.nextInt(500), Random.nextInt(10000)));
        }
    }

}
