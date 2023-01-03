package com.visualg.animations.kandynsky;

import com.visualg.util.Pair;

import java.io.Serializable;

interface Element extends Serializable {
    Pair<Float, Float> getCenter();

    void move(int x, int y);

    double distance(int x, int y);

    void rotate(int degree);
}
