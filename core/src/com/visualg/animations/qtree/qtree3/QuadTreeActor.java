package com.visualg.animations.qtree.qtree3;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.BouncingBall;
import com.visualg.util.Mouse;
import com.visualg.util.color.ColorGenerator;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.Rectangle;

import java.util.ArrayList;

import static com.visualg.animations.qtree.qtree3.Settings.INSTANCE;

class QuadTreeActor extends ShapeRendererActor {

    private final QuadTreeAlg alg;

    protected QuadTreeActor() {
        super(ShapeRenderer.ShapeType.Line);
        alg = new QuadTreeAlg();
    }

    @Override
    protected void drawFrame() {
        sr.setColor(Config.getUserPrimaryColor());
        final ArrayList<BouncingBall> particles = alg.getBouncingBalls();
        for (BouncingBall particle : particles) {
            sr.circle(particle.getPosition().x, particle.getPosition().y, 1);
        }
        sr.setColor(ColorGenerator.fromHSV((Mouse.getX() / (float) Config.WIDTH) * 360, 1, 0.75f));
        for (BouncingBall particle : particles) {
            final ArrayList<Point> connectedParticles = alg.getParticlesInRect(new Rectangle(particle.getPosition().x, particle.getPosition().y, INSTANCE.getRectSize(), INSTANCE.getRectSize()));
            for (Point connectedParticle : connectedParticles) {
                sr.line(particle.getPosition().x, particle.getPosition().y, connectedParticle.x(), connectedParticle.y());
            }
        }
        alg.update();
    }
}
