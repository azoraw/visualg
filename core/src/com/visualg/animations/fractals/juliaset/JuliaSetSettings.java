package com.visualg.animations.fractals.juliaset;

import com.visualg.ui.settings.Settings;
import com.visualg.util.ComplexNumber;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class JuliaSetSettings implements Settings {

    static final JuliaSetSettings settings = new JuliaSetSettings();

    private int numberOfIteration = 1000;
    private int rMultiplier = 0;
    private int gMultiplier = 13;
    private int bMultiplier = 13;

    private ComplexNumber complexNumber = new ComplexNumber(-0.01994, 0.88634);
    private double moveDelta = 0.002;
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
        double x = 1.5 * ((screenX * 2d / fractalWidth) - 1) / zoom;
        double y = ((screenY * 2d / fractalHeight) - 1) / zoom;
        xOffset -= x;
        yOffset -= y;
    }

    void moveJulia(Direction direction) {
        switch (direction) {
            case UP -> complexNumber = complexNumber.move(0, moveDelta);
            case DOWN -> complexNumber = complexNumber.move(0, -moveDelta);
            case LEFT -> complexNumber = complexNumber.move(-moveDelta, 0);
            case RIGHT -> complexNumber = complexNumber.move(moveDelta, 0);
        }
    }
}
