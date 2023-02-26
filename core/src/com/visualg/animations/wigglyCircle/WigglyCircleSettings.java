package com.visualg.animations.wigglyCircle;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class WigglyCircleSettings implements Settings {
    static final WigglyCircleSettings settings = new WigglyCircleSettings();


    private boolean thresholdEnabled;
    private float zDelta = 0.01f;
    private float z = 1;
    private int maxRadius = 700;
    private int vertexNumber = 1000;
    private int startingRadius = 300;
    private double noiseDeltaX = 1;
    private double noiseDeltaY = 1;

    void incrementZ() {
        z += zDelta;
    }

    void setVertexNumber(int vertexNumber) {
        if (vertexNumber > 1000) {
            this.vertexNumber = 1000;
        } else if (vertexNumber < 3) {
            this.vertexNumber = 3;
        } else {
            this.vertexNumber = vertexNumber;
        }

    }
}
