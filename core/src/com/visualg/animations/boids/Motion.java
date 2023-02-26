package com.visualg.animations.boids;

import lombok.Getter;

import static com.visualg.util.RandomDecorator.Random;

@Getter
class Motion {

    private final BoidsSettings boidsSettings;
    private double dx;
    private double dy;

    Motion(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        randomDirection();
    }

    private void randomDirection() {
        dx = Random.nextInt(2 * boidsSettings.getMinSpeed() + 1) - boidsSettings.getMinSpeed();
        dy = Math.sqrt(Math.pow(boidsSettings.getMinSpeed(), 2) - Math.pow(dx, 2)) * (Random.nextBoolean() ? 1 : -1);
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
        if (z > boidsSettings.getMaxSpeed()) {
            dx = dx * boidsSettings.getMaxSpeed() / z;
            dy = dy * boidsSettings.getMaxSpeed() / z;
        }
    }

    private void minSpeedLimit(double z) {
        if (z < boidsSettings.getMinSpeed()) {
            if(z == 0 ) {
                randomDirection();
                return;
            }
            dx = boidsSettings.getMinSpeed() * dx / z;
            dy = boidsSettings.getMinSpeed() * dy / z;
        }
    }
}
