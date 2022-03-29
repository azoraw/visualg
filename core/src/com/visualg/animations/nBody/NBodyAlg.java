package com.visualg.animations.nBody;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class NBodyAlg {

    private final int width;
    private final int height;
    private final CurrentSettings settings;

    @Getter
    private final List<Body> bodies = new ArrayList<>();

    public NBodyAlg(int width, int height, CurrentSettings currentSettings) {
        this.width = width;
        this.height = height;
        this.settings = currentSettings;
        for (int i = 0; i < currentSettings.getNumberOfBodies(); i++) {
            bodies.add(new Body(new Vector2(RandomGenerator.getIntInRange(width), RandomGenerator.getIntInRange(height)), currentSettings));
        }
    }

    void update() {
        for (Body body1 : bodies) {
            for (Body body2 : bodies) {
                if (body1 != body2) {
                    body1.applyForceFrom(body2);
                }
            }
        }
        for (Body body : bodies) {
            body.update();
        }

    }
}
