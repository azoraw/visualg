package com.visualg.animations.boids;

import com.visualg.util.RandomGenerator;
import lombok.Getter;

@Getter
public class Motion {

    private final BoidsSettings boidsSettings;
    private double dx;
    private double dy;

    public Motion(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        randomDirection();
    }

    private void randomDirection() {
        dx = RandomGenerator.getIntInRange(2 * boidsSettings.getMinSpeed() + 1) - boidsSettings.getMinSpeed();
        dy = Math.sqrt(Math.pow(boidsSettings.getMinSpeed(), 2) - Math.pow(dx, 2)) * (RandomGenerator.nextBoolean() ? 1 : -1);
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
