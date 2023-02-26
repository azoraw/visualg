package com.visualg.animations.boids;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
class Boid {

    private final BoidsSettings boidsSettings;
    private final Position position;

    @Setter
    private List<Boid> neighbours = new ArrayList<>();

    Boid(BoidsSettings boidsSettings) {
        this.boidsSettings = boidsSettings;
        this.position = new Position(boidsSettings);
    }

    void move() {
        position.move(neighbours);
    }


    boolean isNeighbour(Position possibleNeighbourPosition) {
        double x1 = position.getX();
        double x2 = possibleNeighbourPosition.getX();
        double y1 = position.getY();
        double y2 = possibleNeighbourPosition.getY();
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) < Math.pow(boidsSettings.getNeighbourRadius(), 2);
    }
}
