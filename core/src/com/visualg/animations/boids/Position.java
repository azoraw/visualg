package com.visualg.animations.boids;

import com.visualg.global.Config;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
class Position {

    private final Motion currentMotion;
    private final Settings settings;

    private double x;
    private double y;
    private double tmpDX;
    private double tmpDY;

    Position(Settings settings) {
        this.settings = settings;
        x = RandomGenerator.Random.nextInt(Config.WIDTH);
        y = RandomGenerator.Random.nextInt(Config.HEIGHT);
        currentMotion = new Motion(settings);
    }

    void move(List<Boid> neighbours) {
        List<Position> neighboursPosition = neighbours.stream()
                .map(Boid::getPosition)
                .collect(Collectors.toList());
        tmpDX = currentMotion.getDx();
        tmpDY = currentMotion.getDy();

        goTowardsCenterOfMass(neighboursPosition);
        doNotCollide(neighboursPosition.stream().filter(this::isTooClose).collect(Collectors.toList()));
        alignWithOthers(neighboursPosition.stream()
                .map(Position::getCurrentMotion)
                .collect(Collectors.toList()));
        teleportToOtherSide();

        currentMotion.setNewMotion(tmpDX, tmpDY);
        x += currentMotion.getDx();
        y += currentMotion.getDy();
    }

    private void alignWithOthers(List<Motion> neighboursDirections) {
        double alignDx = 0;
        double alignDy = 0;
        for (Motion neighbourDirection : neighboursDirections) {
            if (neighbourDirection.getDx() > currentMotion.getDx()) {
                alignDx += settings.getAlignmentForce();
            }
            if (neighbourDirection.getDx() < currentMotion.getDx()) {
                alignDx -= settings.getAlignmentForce();
            }
            if (neighbourDirection.getDy() > currentMotion.getDy()) {
                alignDy += settings.getAlignmentForce();
            }
            if (neighbourDirection.getDy() < currentMotion.getDy()) {
                alignDy -= settings.getAlignmentForce();
            }
        }
        if (neighboursDirections.size() != 0) {
            tmpDX += alignDx / neighboursDirections.size();
            tmpDY += alignDy / neighboursDirections.size();
        }
    }

    private void goTowardsCenterOfMass(List<Position> positions) {
        double cohesionDX = 0;
        double cohesionDY = 0;
        for (Position position : positions) {
            if (position.getX() - x > 0) {
                cohesionDX += settings.getCohesionForce();
            }
            if (position.getX() - x < 0) {
                cohesionDX -= settings.getCohesionForce();
            }
            if (position.getY() - y > 0) {
                cohesionDY += settings.getCohesionForce();
            }
            if (position.getY() - y < 0) {
                cohesionDY -= settings.getCohesionForce();
            }
        }
        if (positions.size() != 0) {
            tmpDX += cohesionDX / positions.size();
            tmpDY += cohesionDY / positions.size();
        }
    }

    private void doNotCollide(List<Position> positions) {
        double collisionDX = 0;
        double collisionDY = 0;
        for (Position position : positions) {
            if (position.getX() - x > 0)
                collisionDX -= settings.getCollisionRepulsionForce();
            if (position.getX() - x < 0)
                collisionDX += settings.getCollisionRepulsionForce();
            if (position.getY() - y > 0)
                collisionDY -= settings.getCollisionRepulsionForce();
            if (position.getY() - y < 0)
                collisionDY += settings.getCollisionRepulsionForce();

        }
        if (positions.size() != 0) {
            tmpDX += collisionDX / positions.size();
            tmpDY += collisionDY / positions.size();
        }
    }

    private void teleportToOtherSide() {
        if (x < 0) {
            x = Config.WIDTH - 1;
        }
        if (y < 0) {
            y = Config.HEIGHT - 1;
        }
        if (x > Config.WIDTH) {
            x = 0;
        }
        if (y > Config.HEIGHT) {
            y = 0;
        }
    }

    boolean isTooClose(Position possibleNeighbourPosition) {
        double x2 = possibleNeighbourPosition.getX();
        double y2 = possibleNeighbourPosition.getY();
        return Math.pow(x - x2, 2) + Math.pow(y - y2, 2) < Math.pow(settings.getCollidingRadius(), 2);
    }
}
