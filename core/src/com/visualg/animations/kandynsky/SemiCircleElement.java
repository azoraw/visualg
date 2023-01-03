package com.visualg.animations.kandynsky;

import com.visualg.util.Pair;
import lombok.Data;

import java.io.Serial;

@Data
class SemiCircleElement implements Element {
    @Serial
    private static final long serialVersionUID = 1L;

    private int x;
    private int y;
    private int radius;
    private int rotation;

    SemiCircleElement(int x, int y, int radius, int rotation) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.rotation = rotation;
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
    public void rotate(int angle) {
        rotation += angle;
    }


}
