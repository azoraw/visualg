package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public enum SimplexColorMode {
    GRAYSCALE(SimplexColorMode::getGreyScale),
    BLACK_AND_WHITE(SimplexColorMode::getCow);

    @Getter
    private Function<Double, Integer> colorFunction;

    SimplexColorMode(Function<Double, Integer> colorFunction) {
        this.colorFunction = colorFunction;
    }

    private static int getGreyScale(double simpleNoiseValue) {
        return Color.rgba8888(1, 1, 1, (float) (simpleNoiseValue + 1) / 2);
    }

    private static int getCow(double simpleNoiseValue) {
        return Color.rgba8888(1, 1, 1, simpleNoiseValue > 0 ? 1 : 0);
    }
}
