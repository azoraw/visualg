package com.visualg.animations.boids;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class BoidsSettings {

    static BoidsSettings INSTANCE = new BoidsSettings();


    private int numberOfBoids = 500;

    private int maxSpeed = 10;
    private int minSpeed = 5;

    private double alignmentForce = 1;
    private double cohesionForce = 0.5;

    private double collisionRepulsionForce = 3;
    private int collidingRadius = 20;

    private int neighbourRadius = 100;

    private int circleRadius = 1;

}
