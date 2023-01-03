package com.visualg.animations.boids;

import lombok.Getter;

import static com.visualg.util.RandomGenerator.Random;

@Getter
class Motion {

    private final Settings settings;
    private double dx;
    private double dy;

    Motion(Settings settings) {
        this.settings = settings;
        randomDirection();
    }

    private void randomDirection() {
        dx = Random.nextInt(2 * settings.getMinSpeed() + 1) - settings.getMinSpeed();
        dy = Math.sqrt(Math.pow(settings.getMinSpeed(), 2) - Math.pow(dx, 2)) * (Random.nextBoolean() ? 1 : -1);
    }

    void setNewMotion(double newDX, double newDY) {
        dx = newDX;
        dy = newDY;
        limitSpeed();
    }

    private void limitSpeed() {
        double z = Math.sqrt(dx * dx + dy * dy);
        maxSpeedLimit(z);
        minSpeedLimit(z);
    }

    private void maxSpeedLimit(double z) {
        if (z > settings.getMaxSpeed()) {
            dx = dx * settings.getMaxSpeed() / z;
            dy = dy * settings.getMaxSpeed() / z;
        }
    }

    private void minSpeedLimit(double z) {
        if (z < settings.getMinSpeed()) {
            if(z == 0 ) {
                randomDirection();
                return;
            }
            dx = settings.getMinSpeed() * dx / z;
            dy = settings.getMinSpeed() * dy / z;
        }
    }
}
