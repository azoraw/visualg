package com.visualg.util.qTree;

public class Circle {
    float x, y, r;

    public Circle(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    Circle(Circle other) {
        this.x = other.x;
        this.y = other.y;
        this.r = other.r;
    }

    boolean contains(Point point) {
        return (point.x() - x) * (point.x() - x) + (point.y() - y) * (point.y() - y) <= r * r;
    }

    boolean intersects(Circle range) {
        return !(range.x - range.r > x + r
                || range.x + range.r < x - r
                || range.y - range.r > y + r
                || range.y + range.r < y - r);
    }
}
