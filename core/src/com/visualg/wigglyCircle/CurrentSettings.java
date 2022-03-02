package com.visualg.wigglyCircle;

import lombok.Data;

@Data
class CurrentSettings {
    private boolean applyThreshold;
    private float zDelta = 0.01f;
    private float z = 1;


    public void incrementZ() {
        z += zDelta;
    }
}
