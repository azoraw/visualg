package com.visualg.animations.fractals.multibrot;

import com.visualg.util.ComplexNumber;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
class Settings {

    static Settings INSTANCE = Settings.builder()
            .numberOfIteration(30)
            .rMultiplier(0)
            .gMultiplier(1)
            .bMultiplier(13)
            .multibrotPower(new ComplexNumber(2, 0))
            .moveDelta(0.5)
            .xOffset(0)
            .yOffset(0)
            .zoom(1)
            .zoomMultiplier(2)
            .build();

    private int numberOfIteration;
    private int rMultiplier;
    private int gMultiplier;
    private int bMultiplier;

    private ComplexNumber multibrotPower;
    private double moveDelta;
    private double xOffset;
    private double yOffset;
    private double zoom;
    private double zoomMultiplier;

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
