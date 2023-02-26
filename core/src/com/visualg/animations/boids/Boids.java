package com.visualg.animations.boids;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
class Boids {
    private final List<Boid> boids = new ArrayList<>();
    private final BoidsSettings boidsSettings;

    Boids(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        for (int i = 0; i < boidsSettings.getNumberOfBoids(); i++) {
            boids.add(new Boid(boidsSettings));
        }
    }

    void move() {
        updateWhoIsNeighbour();
        for (Boid boid : boids) {
            boid.move();
        }
    }

    void updateWhoIsNeighbour() {
        boids.forEach(
                boid -> boid.setNeighbours(boids.stream()
                        .filter(possibleNeighbour -> boid != possibleNeighbour
                                && boid.isNeighbour(possibleNeighbour.getPosition()))
                        .collect(Collectors.toList()))
        );
    }
}
