package com.visualg.animations.circlePacking;

import com.badlogic.gdx.graphics.Color;

class Circle implements Comparable<Circle> {
    private static final int initR = 1;

    final int x;
    final int y;
    Color color;
    double r;
    boolean canGrow = true;

    Circle(int x, int y, int pixel) {
        this.x = x;
        this.y = y;
        this.r = initR;
        color = new Color(pixel);
    }


    @Override
    public int compareTo(Circle o) {
        if (o.r == r) {
            return 0;
        } else if (r > o.r) {
            return 1;
        }
        return -1;
    }
}
