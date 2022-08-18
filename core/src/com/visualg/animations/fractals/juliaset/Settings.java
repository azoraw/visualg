package com.visualg.animations.fractals.juliaset;

import com.visualg.animations.fractals.ComplexNumber;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
class Settings {

    static Settings INSTANCE = Settings.builder()
            .numberOfIteration(1000)
            .rMultiplier(0)
            .gMultiplier(13)
            .bMultiplier(13)
            .complexNumber(new ComplexNumber(-0.01994, 0.88634))
            .moveDelta(0.002)
            .xOffset(0)
            .yOffset(0)
            .zoom(1)
            .zoomMultiplier(2)
            .build();

    private int numberOfIteration;
    private int rMultiplier;
    private int gMultiplier;
    private int bMultiplier;

    private ComplexNumber complexNumber;
    private double moveDelta;
    private double xOffset;
    private double yOffset;
    private double zoom;
    private double zoomMultiplier;

    void zoom(Zoom zoom) {
        if (zoom == Zoom.IN) {
            this.zoom *= zoomMultiplier;
        } else
            this.zoom /= zoomMultiplier;
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
        double x = 1.5 * (((double) screenX * 2 / fractalWidth) - 1) / this.zoom;
        double y = (((double) screenY * 2 / fractalHeight) - 1) / this.zoom;
        xOffset -= x;
        yOffset -= y;
    }

    void moveJulia(Direction direction) {
        switch (direction) {
            case UP -> complexNumber = this.complexNumber.move(0, moveDelta);
            case DOWN -> complexNumber = this.complexNumber.move(0, -moveDelta);
            case LEFT -> complexNumber = this.complexNumber.move(-moveDelta, 0);
            case RIGHT -> complexNumber = this.complexNumber.move(moveDelta, 0);
        }
    }
}
