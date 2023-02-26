package com.visualg.animations.fractals.multibrot;

import com.visualg.ui.settings.Settings;
import com.visualg.util.ComplexNumber;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class MultibrotSettings implements Settings {

    static final MultibrotSettings settings = new MultibrotSettings();

    private int numberOfIteration = 30;
    private int rMultiplier = 0;
    private int gMultiplier = 1;
    private int bMultiplier = 13;

    private ComplexNumber multibrotPower = new ComplexNumber(2, 0);
    private double moveDelta = (0.5);
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

    void moveSet(Direction direction) {
        switch (direction) {
            case UP:
            case DOWN:
                break;
            case LEFT:
                multibrotPower = this.multibrotPower.move(-moveDelta, 0);
                break;
            case RIGHT:
                multibrotPower = this.multibrotPower.move(moveDelta, 0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}
