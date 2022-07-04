package com.visualg.animations.doublePendulum;

import com.visualg.global.Config;
import lombok.Getter;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

@Getter
public class State {
    private final int length1 = 100;
    private final int length2 = 100;
    private final int m1 = 10;
    private final int m2 = 10;
    private final double g = 1;

    private final double x0;
    private final double y0;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    private double angle1 = PI * 3 / 4;
    private double angle2 = PI * 3 / 4;
    private double velocity1 = 0;
    private double velocity2 = 0;

    State() {
        x0 = (float) Config.WIDTH / 2;
        y0 = (float) Config.HEIGHT / 2;
        calculatePositions();
    }

    void updateState() {
        double velocity1Tmp = calculateAcceleration1();
        double velocity2Tmp = calculateAcceleration2();
        velocity1 += velocity1Tmp;
        velocity2 += velocity2Tmp;
        //limit();
        angle1 += velocity1;
        angle2 += velocity2;

        calculatePositions();
    }

    public double getY1() {
        return 2 * y0 - y1;
    }

    public double getY2() {
        return 2 * y0 - y2;
    }

    private void limit() {
        if (velocity1 > 1) {
            velocity1 = 0;
        }
        if (velocity1 < -1) {
            velocity1 = 0;
        }
        if (velocity2 > 1) {
            velocity2 = 0;
        }
        if (velocity2 < -1) {
            velocity2 = 0;
        }
    }

    private double calculateAcceleration1() {
        double num = -g * (2 * m1 + m2) * sin(angle1)
                - m2 * g * sin(angle1 - 2 * angle2)
                - 2 * sin(angle1 - angle2) * m2 * velocity2 * velocity2 * length2
                + velocity1 * velocity1 * length1 * cos(angle1 - angle2);
        double den = length1 * (2 * m1 + m2 - m2 * cos(2 * angle1 - 2 * angle2));
        return num / den;
    }

    private double calculateAcceleration2() {
        double num = 2 * sin(angle1 - angle2) * (velocity1 * velocity1 * length1 * (m1 + m2)
                + g * (m1 + m2) * cos(angle1)
                + velocity2 * velocity2 * length2 * m2 * cos(angle1 - angle2));
        double den = length2 * (2 * m1 + m2 - m2 * cos(2 * angle1 - 2 * angle2));
        return num / den;
    }

    private void calculatePositions() {
        x1 = x0 + length1 * sin(angle1);
        y1 = y0 + length1 * cos(angle1);
        x2 = x1 + length2 * sin(angle2);
        y2 = y1 + length2 * cos(angle2);
    }
}
