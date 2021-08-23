package com.visualg.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.BouncingBall;
import com.visualg.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.visualg.bezier.BezierFunctionAlg.getQuadraticBezier;

public class OldWidowsScreenSaver {

    private static final int movementSpeed =5;
    private static final int DELTA = 20;

    List<BouncingBall> bouncingBalls = new ArrayList<>();

    public OldWidowsScreenSaver(int width, int height) {
        bouncingBalls.add(new BouncingBall(height, 1, 1, width, movementSpeed));
        bouncingBalls.add(new BouncingBall(height, 1, 1, width, movementSpeed));
        bouncingBalls.add(new BouncingBall(height, 1, 1, width, movementSpeed));
        bouncingBalls.add(new BouncingBall(height, 1, 1, width, movementSpeed));
    }

    public Set<Pair<Vector2, Vector2>> getLines() {
        return getQuadraticBezier(
                bouncingBalls.get(0).getPosition(),
                bouncingBalls.get(1).getPosition(),
                bouncingBalls.get(2).getPosition(),
                bouncingBalls.get(3).getPosition(),
                DELTA);
    }

    public void update() {
        bouncingBalls.forEach(BouncingBall::update);
    }
}
