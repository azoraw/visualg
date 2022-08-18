package com.visualg.animations.spiral;

class Spiral {

    private int currentSideLength = 0;
    private int sideLength = 1;

    void incrementCurrentSideLength() {
        currentSideLength++;
    }

    void incrementSideLength() {
        sideLength++;
    }

    boolean canTurn() {
        return currentSideLength == sideLength;
    }

    void resetCurrentSideLength() {
        currentSideLength = 0;
    }
}