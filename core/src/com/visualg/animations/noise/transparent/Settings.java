package com.visualg.animations.noise.transparent;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.visualg.util.RandomGenerator.Random;
import static java.lang.Math.max;
import static java.lang.Math.min;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {

    static Settings INSTANCE = new Settings();

    private boolean isConnectedWithStartingPoint = false;
    private float alpha = 0.01f;
    private int numberOfAgents = 1000;
    private double step = 0.01;
    private float fieldMagnitude = 0.01f;
    private int initFrameSkips = 0;
    private int randomColorDelta = Random.nextInt(360);
    private Colors colors = Colors.MONOCHROMATIC;
    private ColorInputSrc colorInputSrc = ColorInputSrc.VELOCITY;

    void setAlpha(float alpha) {
        this.alpha = min(max(alpha, 0.01f), 1);
    }

    void restartColor() {
        randomColorDelta = Random.nextInt(360);
    }
}
