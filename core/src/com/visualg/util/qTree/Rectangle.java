package com.visualg.util.qTree;

public class Rectangle {
    float x, y;
    float w, h;

    public Rectangle(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    Rectangle(Rectangle other) {
        this.x = other.x;
        this.y = other.y;
        this.w = other.w;
        this.h = other.h;
    }

    boolean contains(Point point) {
        return point.x() >= x - w
                && point.x() <= x + w
                && point.y() >= y - h
                && point.y() <= y + h;
    }

    boolean intersects(Rectangle range) {
        return !(range.x - range.w > x + w
                || range.x + range.w < x - w
                || range.y - range.h > y + h
                || range.y + range.h < y - h);
    }

    boolean intersects(Circle range) {
        return !(range.x - range.r > x + w
                || range.x + range.r < x - w
                || range.y - range.r > y + h
                || range.y + range.r < y - h);
    }
}
