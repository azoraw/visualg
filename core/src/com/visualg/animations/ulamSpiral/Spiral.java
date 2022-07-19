package com.visualg.animations.ulamSpiral;

public class Spiral {

    private int currentSideLength = 0;
    private int sideLength = 1;

    public void incrementCurrentSideLength() {
        currentSideLength++;
    }

    public void incrementSideLength() {
        sideLength++;
    }

    public boolean canTurn() {
        return currentSideLength == sideLength;
    }

    public void resetCurrentSideLength() {
        currentSideLength = 0;
    }
}