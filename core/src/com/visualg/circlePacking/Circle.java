package com.visualg.circlePacking;

class Circle implements Comparable<Circle> {
    private static final int initR = 1;

    final int x;
    final int y;
    double r;
    boolean canGrow = true;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        this.r = initR;
    }


    @Override
    public int compareTo(Circle o) {
        if (o.r == r) {
            return 0;
        } else if (r > o.r) {
            return -1;
        }
        return 1;
    }
}
