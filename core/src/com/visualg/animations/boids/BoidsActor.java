package com.visualg.animations.boids;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.ui.ShapeRendererActor;

class BoidsActor extends ShapeRendererActor {

    private final BoidsSettings boidsSettings;
    private final Boids boids;

    BoidsActor(BoidsSettings boidsSettings) {
        super(ShapeRenderer.ShapeType.Line);
        this.boidsSettings = boidsSettings;
        boids = new Boids(boidsSettings);
    }

    @Override
    protected void drawFrame() {
        for (Boid boid : boids.getBoids()) {
            sr.circle((int) boid.getPosition().getX(), (int) boid.getPosition().getY(), boidsSettings.getCircleRadius());
        }
        boids.move();
    }
}
