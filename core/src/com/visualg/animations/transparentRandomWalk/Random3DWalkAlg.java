package com.visualg.animations.transparentRandomWalk;

import com.visualg.global.Config;
import com.visualg.util.Direction3D;
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
    private Direction3D previousDir = Direction3D.DOWN;

    public Random3DWalkAlg(int cellSize) {
        X_LENGTH = Config.WIDTH / cellSize;
        Y_LENGTH = Config.HEIGHT / cellSize;
        Z_LENGTH = 100;
        x = RandomGenerator.Random.nextInt(X_LENGTH);
        y = RandomGenerator.Random.nextInt(Y_LENGTH);
        z = RandomGenerator.Random.nextInt(Z_LENGTH);

    }

    void update() {
        final Direction3D randomDirection3D = getRandomDirection();
        previousDir = randomDirection3D;
        int newX = x + randomDirection3D.getX();
        int newY = y + randomDirection3D.getY();
        int newZ = z + randomDirection3D.getZ();

        if (isXValid(newX) && isYValid(newY) && isZValid(newZ)) {
            x = newX;
            y = newY;
            z = newZ;
        } else {
            x += randomDirection3D.getOppositeX();
            y += randomDirection3D.getOppositeY();
            z += randomDirection3D.getOppositeZ();
        }

    }

    public Direction3D getRandomDirection() {
        Set<Direction3D> possibleDirs = EnumSet.allOf(Direction3D.class);
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
