package com.visualg.animations.transparentRandomWalk;

import com.visualg.global.Config;
import com.visualg.util.Direction3d;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

class Random3DWalkAlg {
    private final int X_LENGTH;
    private final int Y_LENGTH;
    private final int Z_LENGTH;

    @Getter
    private int x, y, z;
    private Direction3d previousDir = Direction3d.DOWN;

    public Random3DWalkAlg(int cellSize) {
        X_LENGTH = Config.WIDTH / cellSize;
        Y_LENGTH = Config.HEIGHT / cellSize;
        Z_LENGTH = 100;
        x = RandomGenerator.getIntInRange(X_LENGTH);
        y = RandomGenerator.getIntInRange(Y_LENGTH);
        z = RandomGenerator.getIntInRange(Z_LENGTH);

    }

    void update() {
        final Direction3d randomDirection3d = getRandomDirection();
        previousDir = randomDirection3d;
        int newX = x + randomDirection3d.getX();
        int newY = y + randomDirection3d.getY();
        int newZ = z + randomDirection3d.getZ();

        if (isXValid(newX) && isYValid(newY) && isZValid(newZ)) {
            x = newX;
            y = newY;
            z = newZ;
        } else {
            x += randomDirection3d.getOppositeX();
            y += randomDirection3d.getOppositeY();
            z += randomDirection3d.getOppositeZ();
        }

    }

    public Direction3d getRandomDirection() {
        Set<Direction3d> possibleDirs = EnumSet.allOf(Direction3d.class);
        possibleDirs.remove(previousDir);
        return RandomGenerator.getRandomElement(possibleDirs).orElseThrow();
    }


    private boolean isXValid(int x) {
        return x >= 0 && x < X_LENGTH;
    }

    private boolean isYValid(int y) {
        return y >= 0 && y < Y_LENGTH;
    }

    private boolean isZValid(int z) {
        return z >= 0 && z < Z_LENGTH;
    }
}
