package com.visualg.animations.boids;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.util.libgdx.ShapeRendererActor;

public class BoidsActor extends ShapeRendererActor {

    private final BoidsSettings boidsSettings;
    private final Boids boids;

    public BoidsActor(BoidsSettings boidsSettings) {
        super(ShapeRenderer.ShapeType.Line);
        this.boidsSettings = boidsSettings;
        boids = new Boids(boidsSettings);
    }

    @Override
    protected void drawFrame() {
        for (Bird bird : boids.getBirds()) {
            sr.circle((int) bird.getPosition().getX(), (int) bird.getPosition().getY(), boidsSettings.getCircleRadius());
        }
        boids.move();
    }
}
