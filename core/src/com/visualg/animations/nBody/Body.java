package com.visualg.animations.nBody;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;

class Body {

    private final CurrentSettings currentSettings;
    @Getter
    private final Vector2 position;
    private final Vector2 velocity;
    private Vector2 acceleration;


    Body(Vector2 initialPosition, CurrentSettings currentSettings) {
        position = initialPosition;
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
        this.currentSettings = currentSettings;
    }


    void applyForceFrom(Body body) {
        float r = Math.max(position.dst(body.getPosition()), 5);
        acceleration = position.cpy()
                .sub(body.position)
                .scl(-1 * currentSettings.getG() / (float) Math.pow(r, 2)); //F =-G*m1*m2/r^2
        velocity.add(acceleration);
    }

    void update() {
        position.add(velocity);
    }

}
