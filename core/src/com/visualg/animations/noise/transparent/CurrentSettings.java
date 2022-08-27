package com.visualg.animations.noise.transparent;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.visualg.util.RandomGenerator.getIntInRange;
import static java.lang.Math.max;
import static java.lang.Math.min;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class CurrentSettings {

    static CurrentSettings INSTANCE = new CurrentSettings();

    private boolean isConnectedWithStartingPoint = false;
    private float alpha = 0.01f;
    private int numberOfAgents = 1000;
    private double xStep = 0.05;
    private double yStep = 0.05;
    int scale = 10;
    float fieldMagnitude = 0.01f;
    int randomColorDelta = getIntInRange(360);
    Colors colors = Colors.MONOCHROMATIC;

    void setAlpha(float alpha) {
        this.alpha = min(max(alpha, 0.01f), 1);
    }

    void restartColor() {
        randomColorDelta = getIntInRange(360);
    }
}
