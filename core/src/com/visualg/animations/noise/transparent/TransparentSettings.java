package com.visualg.animations.noise.transparent;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.visualg.util.RandomDecorator.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class TransparentSettings implements Settings {

    static final TransparentSettings settings = new TransparentSettings();

    private int tiles = 1;
    private float alpha = 0.01f;
    private int numberOfAgents = 1000;
    private double step = 0.01;
    private float fieldMagnitude = 0.01f;
    private int initFrameSkips = 0;
    private int randomColorDelta = Random.nextInt(360);
    private boolean isConnectedWithStartingPoint = false;
    private boolean haveMiddleCircle = false;
    private Colors colors = Colors.MONOCHROMATIC;
    private ColorInputSrc colorInputSrc = ColorInputSrc.VELOCITY;

    void restartColor() {
        randomColorDelta = Random.nextInt(360);
    }
}
