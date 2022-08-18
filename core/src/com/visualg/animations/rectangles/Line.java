package com.visualg.animations.rectangles;

class Line {
    final float x1;
    final float y1;
    final float x2;
    final float y2;
    private final float diffMultiplier;

    Line(float x1, float y1, float x2, float y2, float diffMultiplier) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.diffMultiplier = diffMultiplier;
    }

    float getNextX() {
        float diff;
        if (x1 > x2)
            diff = getDiffX();
        else if (x1 == x2) {
            diff = 0;
        } else {
            diff = -getDiffX();
        }
        return ((x1 + x2) / 2) + diff;
    }

    float getNextY() {
        float diff;
        if (y1 > y2)
            diff = getDiffY();
        else if (y1 == y2) {
            diff = 0;
        } else
            diff = -getDiffY();
        return ((y1 + y2) / 2) + diff;
    }

    private float getDiffX() {
        return diffMultiplier * Math.abs(x2 - x1) / 2;
    }

    private float getDiffY() {
        return diffMultiplier * Math.abs(y2 - y1) / 2;
    }
}
