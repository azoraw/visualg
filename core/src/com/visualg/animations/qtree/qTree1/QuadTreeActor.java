package com.visualg.animations.qtree.qTree1;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Mouse;
import com.visualg.util.qTree.Circle;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.Rectangle;

import java.util.ArrayList;

import static com.visualg.animations.qtree.qTree1.QTree1Settings.settings;

class QuadTreeActor extends ShapeRendererActor {
    private final QuadTreeAlg alg;

    protected QuadTreeActor() {
        super(ShapeRenderer.ShapeType.Line);
        alg = new QuadTreeAlg();
    }

    @Override
    protected void drawFrame() {
        sr.setColor(Config.palette.getSecondaryColor());
        for (Particle particle : alg.getParticles()) {
            sr.point(particle.getX(), particle.getY(), 0);
        }
        sr.setColor(Config.palette.getPrimaryColor());
        ArrayList<Point> particlesInRect = null;
        if (settings.getMode() == QueryMode.RECT) {
            sr.rect(Mouse.getX() - settings.getRectSize(), Mouse.getY() - settings.getRectSize(), settings.getRectSize() * 2, settings.getRectSize() * 2);
            particlesInRect = alg.getParticlesInRect(new Rectangle(Mouse.getX(), Mouse.getY(), settings.getRectSize(), settings.getRectSize()));
        }
        if (settings.getMode() == QueryMode.CIRCLE) {
            sr.circle(Mouse.getX(), Mouse.getY(), settings.getRectSize());
            particlesInRect = alg.getParticlesInCircle(new Circle(Mouse.getX(), Mouse.getY(), settings.getRectSize()));
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
