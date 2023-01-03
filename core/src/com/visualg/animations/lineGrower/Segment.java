package com.visualg.animations.lineGrower;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.RandomGenerator;
import lombok.Builder;
import lombok.Getter;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.util.RandomGenerator.Random;

@Getter
class Segment {

    private static final float SPEED = 1;
    private static final int[] DIR = getInts();

    private static int[] getInts() {
        int shift = 1;
        int[] ints =new int[shift*2+2];
        int index = 0;
        for (int i = -shift; i < shift; i++) {
            ints[index] = i;
            index++;
        }
        return ints;
    }

    private final Vector2 position;
    private final Vector2 initPosition;
    private final Vector2 velocity;
    int crossed = 0;

    Segment() {
        position = new Vector2(Random.nextInt(WIDTH-1), Random.nextInt(HEIGHT-1));
        initPosition = position.cpy();
        velocity = new Vector2();
        velocity.setToRandomDirection();
        velocity.scl(SPEED);
        initMove();
    }

    @Builder
    Segment(Vector2 position, Vector2 initPosition, Vector2 velocity) {
        this.position = position;
        this.initPosition = initPosition;
        this.velocity = velocity;
    }

    private void initMove() {
        position.add(velocity);
    }

    Segment createPerpendicular() {
        Vector2 lerp = null;
        for (int i = 0; i < 3; i++) {
            lerp = position.cpy().lerp(initPosition, (float) Math.random());
            if (isInbound(lerp)) {
                break;
            }
        }

        Segment segment = Segment.builder()
                .initPosition(lerp)
                .position(lerp)
                .velocity(velocity.cpy().rotate90(Random.nextBoolean() ? -1 : 1))
                .build();
        segment.initMove();
        return segment;
    }

    boolean grow(Segment[][] pixels) {
        if (!isInbound(position)) {
            return false;
        }
        if (isOnAnotherLineSegment(pixels)) {
            crossed++;
            return false;
        }
        position.add(velocity);
        return true;
    }

    private boolean isOnAnotherLineSegment(Segment[][] pixels) {
        int x;
        int y;
        for (int xShift : DIR) {
            for (int yShift : DIR) {
                x = (int) position.x + xShift;
                y = (int) position.y + yShift;
                if (!isInbound(x, y)) {
                    continue;
                }
                if (pixels[x][y] != null
                        && pixels[x][y] != this) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean isInbound(int x, int y) {
        return x > 0 && y > 0 && x < WIDTH && y < HEIGHT;
    }

    private boolean isInbound(Vector2 position) {
        boolean isInbound = true;
        if (position.x < 0) {
            isInbound = false;
            position.x = 0;
        }
        if (position.y < 0) {
            isInbound = false;
            position.y = 0;
        }
        if (position.x > WIDTH) {
            isInbound = false;
            position.x = WIDTH;
        }
        if (position.y > HEIGHT) {
            isInbound = false;
            position.y = HEIGHT;
        }
        return isInbound;
    }


}
