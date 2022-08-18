package com.visualg.animations.boids;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
class Boids {
    private final List<Bird> birds = new ArrayList<>();
    private final BoidsSettings boidsSettings;

    void whoIsNeighbour() {
        birds.forEach(
                bird -> bird.setNeighbours(birds.stream()
                                .filter(possibleNeighbour -> bird != possibleNeighbour
                                        && bird.isNeighbour(possibleNeighbour.getPosition()))
                                .collect(Collectors.toList()))
        );
    }

    Boids(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;

        for (int i = 0; i < boidsSettings.getNumberOfBoids(); i++) {
            birds.add(new Bird(boidsSettings));
        }
    }

    void move() {
        whoIsNeighbour();
        for (Bird bird : birds) {
            bird.move();
        }
    }

    boolean shouldRestart() {
        return birds.size() != boidsSettings.getNumberOfBoids();
    }
}
