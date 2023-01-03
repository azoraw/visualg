package com.visualg.animations.qtree.qtree4;

import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;
import com.visualg.util.BouncingBall;
import com.visualg.util.Mouse;
import com.visualg.util.color.ColorGenerator;
import com.visualg.util.qTree.Point;
import com.visualg.util.qTree.Rectangle;

import java.util.ArrayList;

class QuadTreeActor extends FrameBufferActor {

    private final QuadTreeAlg alg;

    public QuadTreeActor() {
        super(true);
        alg = new QuadTreeAlg();
    }


    @Override
    protected void drawFrame() {
        final ArrayList<BouncingBall> particles = alg.getBouncingBalls();
        sr.setColor(ColorGenerator.fromHSV((Mouse.getX() / (float) Config.WIDTH) * 360, 1, 1,0.01f));
        for (BouncingBall particle : particles) {
            final ArrayList<Point> connectedParticles = alg.getParticlesInRect(new Rectangle(particle.getPosition().x, particle.getPosition().y, Settings.INSTANCE.getRectSize(), Settings.INSTANCE.getRectSize()));
            for (Point connectedParticle : connectedParticles) {
                sr.line(particle.getPosition().x, particle.getPosition().y, connectedParticle.x(), connectedParticle.y());
            }
        }
        alg.update();
    }
}
