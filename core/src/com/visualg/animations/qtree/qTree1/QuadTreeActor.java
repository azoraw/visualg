package com.visualg.animations.qtree.qTree1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Mouse;
import com.visualg.util.qTree.Circle;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.Rectangle;

import java.util.ArrayList;

import static com.visualg.animations.qtree.qTree1.Settings.INSTANCE;

class QuadTreeActor extends ShapeRendererActor {
    private final QuadTreeAlg alg;

    protected QuadTreeActor() {
        super(ShapeRenderer.ShapeType.Line);
        alg = new QuadTreeAlg();
    }

    @Override
    protected void drawFrame() {
        sr.setColor(Color.WHITE);
        for (Particle particle : alg.getParticles()) {
            sr.point(particle.getX(), particle.getY(), 0);
        }
        sr.setColor(Color.GREEN);
        ArrayList<Point> particlesInRect = null;
        if (INSTANCE.getMode() == QueryMode.RECT) {
            sr.rect(Mouse.getX() - INSTANCE.getRectSize(), Mouse.getY() - INSTANCE.getRectSize(), INSTANCE.getRectSize() * 2, INSTANCE.getRectSize() * 2);
            particlesInRect = alg.getParticlesInRect(new Rectangle(Mouse.getX(), Mouse.getY(), INSTANCE.getRectSize(), INSTANCE.getRectSize()));
        }
        if (INSTANCE.getMode() == QueryMode.CIRCLE) {
            sr.circle(Mouse.getX(), Mouse.getY(), INSTANCE.getRectSize());
            particlesInRect = alg.getParticlesInCircle(new Circle(Mouse.getX(), Mouse.getY(), INSTANCE.getRectSize()));
        }

        for (Point point : particlesInRect) {
            for (Point other : particlesInRect) {
                if (point == other) {
                    continue;
                }
                sr.line(point.x(), point.y(), other.x(), other.y());
            }
        }
    }
}
