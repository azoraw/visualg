package com.visualg.wigglyCircle;

import lombok.Data;

@Data
class CurrentSettings {

    private boolean thresholdEnabled;
    private float zDelta = 0.01f;
    private float z = 1;
    private int maxRadius = 700;
    private int vertexNumber = 1000; //2499 max
    private int startingRadius = 300;


    public void incrementZ() {
        z += zDelta;
    }
}
