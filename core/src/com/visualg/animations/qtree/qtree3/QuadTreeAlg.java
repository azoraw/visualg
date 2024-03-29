package com.visualg.animations.qtree.qtree3;

import com.visualg.global.Config;
import com.visualg.util.BouncingBall;
import com.visualg.util.qTree.Circle;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.QTree;
import com.visualg.util.qTree.Rectangle;
import lombok.Getter;

import java.util.ArrayList;

import static com.visualg.animations.qtree.qtree3.Qtree3Settings.settings;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class QuadTreeAlg {
    private static final int QTREE_CAPACITY = 4;

    @Getter
    private final ArrayList<BouncingBall> bouncingBalls = new ArrayList<>();
    private QTree qTree;

    public QuadTreeAlg() {
        qTree = new QTree(new Rectangle(0, 0, Config.WIDTH, Config.HEIGHT), QTREE_CAPACITY);
        for (int i = 0; i < settings.getNumberOfParticles(); i++) {
            final BouncingBall bouncingBall = new BouncingBall(HEIGHT, 1, 1, WIDTH, settings.getMovementSpeed());
            bouncingBalls.add(bouncingBall);
            qTree.insert(new Point(bouncingBall.getPosition().x, bouncingBall.getPosition().y, bouncingBall));
        }
    }

    public ArrayList<Point> getParticlesInCircle(Circle circle) {
        return qTree.query(circle, new ArrayList<>());
    }

    public void update() {
        qTree = new QTree(new Rectangle(0, 0, Config.WIDTH, Config.HEIGHT), QTREE_CAPACITY);
        for (BouncingBall bouncingBall : bouncingBalls) {
            bouncingBall.update();
            qTree.insert(new Point(bouncingBall.getPosition().x, bouncingBall.getPosition().y, bouncingBall));
        }
    }
}
