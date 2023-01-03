package com.visualg.animations.qtree.qtree2;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Mouse;
import com.visualg.util.color.ColorGenerator;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.Rectangle;

import java.util.ArrayList;

class QuadTreeActor extends ShapeRendererActor {
    private final QuadTreeAlg alg;

    protected QuadTreeActor() {
        super(ShapeRenderer.ShapeType.Line);
        alg = new QuadTreeAlg();
    }

    @Override
    protected void drawFrame() {
        sr.setColor(Config.getUserPrimaryColor());
        final ArrayList<Particle> particles = alg.getParticles();
        for (Particle particle : particles) {
            sr.circle(particle.getX(), particle.getY(), 1);
        }
        sr.setColor(ColorGenerator.fromHSV((Mouse.getX() / (float) Config.WIDTH) * 360, 1, 0.75f));
        for (Particle particle : particles) {
            final ArrayList<Point> connectedParticles = alg.getParticlesInRect(new Rectangle(particle.getX(), particle.getY(), Mouse.getY(), Mouse.getY()));
            for (Point connectedParticle : connectedParticles) {
                sr.line(particle.getX(), particle.getY(), connectedParticle.x(), connectedParticle.y());
            }
        }
    }
}
