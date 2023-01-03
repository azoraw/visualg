package com.visualg.animations.boids;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.ui.ShapeRendererActor;

class BoidsActor extends ShapeRendererActor {

    private final Settings settings;
    private final Boids boids;

    BoidsActor(Settings settings) {
        super(ShapeRenderer.ShapeType.Line);
        this.settings = settings;
        boids = new Boids(settings);
    }

    @Override
    protected void drawFrame() {
        for (Boid boid : boids.getBoids()) {
            sr.circle((int) boid.getPosition().getX(), (int) boid.getPosition().getY(), settings.getCircleRadius());
        }
        boids.move();
    }
}
