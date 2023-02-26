package com.visualg.animations.fractals.mandelbrot;

import com.visualg.ui.settings.Settings;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class MandelbrotSettings implements Settings {

    static final MandelbrotSettings INSTANCE = new MandelbrotSettings();

    private int numberOfIteration = 30;
    private int rMultiplier = 0;
    private int gMultiplier = 1;
    private int bMultiplier = 13;

    private double moveDelta = 0.02;
    private double xOffset = 0;
    private double yOffset = 0;
    private double zoom = 1;
    private double zoomMultiplier = 2;

    void zoom(Zoom zoomInput) {
        if (zoomInput == Zoom.IN) {
            zoom *= zoomMultiplier;
        } else
            zoom /= zoomMultiplier;
    }

    void addOffset(Direction direction) {
        double offsetDelta = 0.2 / zoom;
        switch (direction) {
            case UP -> yOffset += offsetDelta;
            case DOWN -> yOffset -= offsetDelta;
            case LEFT -> xOffset += offsetDelta;
            case RIGHT -> xOffset -= offsetDelta;
        }
    }

    void move(int screenX, int screenY, int fractalWidth, int fractalHeight) {
        double x = 1.5 * (((double) screenX * 2 / fractalWidth) - 1) / zoom;
        double y = (((double) screenY * 2 / fractalHeight) - 1) / zoom;
        xOffset -= x;
        yOffset -= y;
    }
}
