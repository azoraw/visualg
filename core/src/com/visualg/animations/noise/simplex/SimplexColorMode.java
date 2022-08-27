package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

import static com.visualg.global.Config.palette;

@RequiredArgsConstructor
enum SimplexColorMode {
    GRAYSCALE(SimplexColorMode::getGreyScale),
    BLACK_AND_WHITE(SimplexColorMode::getCow);

    @Getter
    private Function<Double, Integer> colorFunction;

    SimplexColorMode(Function<Double, Integer> colorFunction) {
        this.colorFunction = colorFunction;
    }

    private static int getGreyScale(double simpleNoiseValue) {
        return Color.rgba8888(palette.getPrimaryColor().r, palette.getPrimaryColor().g, palette.getPrimaryColor().b, (float) (simpleNoiseValue + 1) / 2);
    }

    private static int getCow(double simpleNoiseValue) {
        return Color.rgba8888(palette.getPrimaryColor().r, palette.getPrimaryColor().g, palette.getPrimaryColor().b, simpleNoiseValue > 0 ? 1 : 0);
    }
}
