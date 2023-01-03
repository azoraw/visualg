package com.visualg.animations.qtree.qtree2;

import com.visualg.global.Config;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.QTree;
import com.visualg.util.qTree.Rectangle;
import lombok.Getter;

import java.util.ArrayList;

class QuadTreeAlg {
    private static final int NUMBER_OF_PARTICLES = 1000;
    @Getter
    private final ArrayList<Particle> particles = new ArrayList<>();
    private final QTree qTree;

    public QuadTreeAlg() {
        qTree = new QTree(new Rectangle(0, 0, Config.WIDTH, Config.HEIGHT), 4);
        for (int i = 0; i < NUMBER_OF_PARTICLES; i++) {
            final Particle particle = new Particle();
            particles.add(particle);
            qTree.insert(new Point(particle.getX(), particle.getY(), particle));
        }
    }

    public ArrayList<Point> getParticlesInRect(Rectangle rectangle) {
        return qTree.query(rectangle, new ArrayList<>());
    }
}