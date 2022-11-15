package com.visualg.util;

import lombok.Getter;

@Getter
public enum Direction3d {
    UP(0, 1, 0),
    DOWN(0, -1, 0),
    RIGHT(1, 0, 0),
    LEFT(-1, 0, 0),
    FORWARD(0, 0, 1),
    BACKWARD(0, 0, -1);

    private final int x;
    private final int y;
    private final int z;
    private final int oppositeX;
    private final int oppositeY;
    private final int oppositeZ;

    Direction3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        oppositeX = -x;
        oppositeY = -y;
        oppositeZ = -z;
    }
}
