package com.visualg.animations.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.visualg.animations.bezier.BezierFunctionAlg.getQuadraticBezier;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class OldWidowsScreenSaver {

    private static final int movementSpeed = 5;
    private static final int DELTA = 20;

    List<BouncingBall> bouncingBalls = new ArrayList<>();

    OldWidowsScreenSaver() {
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
        bouncingBalls.add(new BouncingBall(HEIGHT, 1, 1, WIDTH, movementSpeed));
    }

    Set<Pair<Vector2, Vector2>> getLines() {
        return getQuadraticBezier(
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
