package com.visualg.animations.nBody;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class NBodyAlg {

    private final CurrentSettings settings;

    @Getter
    private final List<Body> bodies = new ArrayList<>();

    public NBodyAlg(CurrentSettings currentSettings) {

        this.settings = currentSettings;
        for (int i = 0; i < currentSettings.getNumberOfBodies(); i++) {
            bodies.add(new Body(new Vector2(RandomGenerator.getIntInRange(WIDTH), RandomGenerator.getIntInRange(HEIGHT)), currentSettings));
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
