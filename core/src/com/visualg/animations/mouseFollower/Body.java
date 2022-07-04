package com.visualg.animations.mouseFollower;

import com.badlogic.gdx.math.Vector2;
import com.visualg.global.Config;
import lombok.Getter;

class Body {
    private final double g = 10;
    @Getter
    private final Vector2 position;
    private final Vector2 velocity;
    private Vector2 acceleration;


    Body() {
        position = new Vector2(Config.WIDTH / 2, Config.HEIGHT / 2);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }


    void applyForceFrom(Vector2 mousePos) {
        float r = Math.max(position.dst(mousePos), 5);
        acceleration = position.cpy()
                .sub(mousePos)
                .scl((float) (-1 * g / (float) Math.pow(r, 2))); //F =-G*m1*m2/r^2
        velocity.add(acceleration);
        position.add(velocity);

    }

}
