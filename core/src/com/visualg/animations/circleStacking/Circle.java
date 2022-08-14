package com.visualg.animations.circleStacking;

import com.badlogic.gdx.math.Vector2;
import lombok.Builder;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

class Circle {
    private final int stepsNo;
    private final int radius;
    private double x;
    private double y;
    private double t = 0;
    private float xCenter;
    private float yCenter;

    @Builder
    public Circle(int stepsNo, int radius, int xCenter, int yCenter) {
        this.stepsNo = stepsNo;
        this.radius = radius;
        updateCenter(xCenter, yCenter);
    }

    public Vector2 getEnd() {
        return new Vector2((float) x + xCenter, (float) y + yCenter);
    }

    public void update(int xCenter, int yCenter) {
        x = radius * cos(t);
        y = radius * sin(t);
        t += 2 * PI / stepsNo;
        updateCenter(xCenter, yCenter);
    }

    private void updateCenter(int xCenter, int yCenter) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }
}
