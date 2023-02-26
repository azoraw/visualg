package com.visualg.animations.bezier;

import com.visualg.util.BouncingBall;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class OldWidowsScreenSaver {

    private static final int movementSpeed = 5;
    private static final int DELTA = 20;
    private final BezierFunctionAlg bezierFunctionAlg;

    List<BouncingBall> bouncingBalls = new ArrayList<>();

    OldWidowsScreenSaver(int index) {
        bezierFunctionAlg = new BezierFunctionAlg(index);
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
    }

    Set<Line> getLines() {
        return bezierFunctionAlg.getQuadraticBezier(
                bouncingBalls.get(0).getPosition(),
                bouncingBalls.get(1).getPosition(),
                bouncingBalls.get(2).getPosition(),
                bouncingBalls.get(3).getPosition(),
                DELTA);
    }


    void update() {
        bouncingBalls.forEach(BouncingBall::update);
    }
}
