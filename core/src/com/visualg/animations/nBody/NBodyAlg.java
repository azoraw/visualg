package com.visualg.animations.nBody;

import com.badlogic.gdx.math.Vector2;
import com.visualg.global.Config;
import com.visualg.util.RandomDecorator;
import com.visualg.util.qTree.Circle;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.QTree;
import com.visualg.util.qTree.Rectangle;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.animations.nBody.NBodySettings.settings;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class NBodyAlg {
    @Getter
    private final List<Body> bodies = new ArrayList<>();
    private QTree qTree;

    NBodyAlg() {
        qTree = new QTree(new Rectangle(0, 0, Config.WIDTH, Config.HEIGHT), 4);
        for (int i = 0; i < settings.getNumberOfBodies(); i++) {
            final Body body = new Body(new Vector2(RandomDecorator.Random.nextInt(WIDTH), RandomDecorator.Random.nextInt(HEIGHT)), settings);
            bodies.add(body);
            qTree.insert(new Point(body.getPosition().x, body.getPosition().y, body));
        }
    }

    void update() {
        for (Body body : bodies) {
            final ArrayList<Point> neighbours = qTree.query(new Circle(body.getPosition().x, body.getPosition().y, settings.getVisibilityRadius()), new ArrayList<>());
            for (Point neighbour : neighbours) {
                if (body != neighbour.data()) {
                    body.applyForceFrom((Body) neighbour.data());
                }
            }
        }
        for (Body body : bodies) {
            body.update();
        }
        qTree = new QTree(new Rectangle(0, 0, Config.WIDTH, Config.HEIGHT), 4);
        for (Body body : bodies) {
            qTree.insert(new Point(body.getPosition().x, body.getPosition().y, body));
        }

    }
}
