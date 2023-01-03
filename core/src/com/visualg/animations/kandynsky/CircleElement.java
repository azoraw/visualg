package com.visualg.animations.kandynsky;

import com.visualg.util.Pair;
import lombok.Data;

import java.io.Serial;

@Data
final class CircleElement implements Element {
    @Serial
    private static final long serialVersionUID = 1L;

    private int x;
    private int y;
    private int radius;

    CircleElement(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public Pair<Float, Float> getCenter() {
        return new Pair<>((float) x, (float) y);
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double distance(int x, int y) {
        return Math.abs(Math.sqrt((Math.pow((x - this.x), 2))
                + (Math.pow((y - this.y), 2)))
                - radius);
    }

    @Override
    public void rotate(int degree) {}
}
