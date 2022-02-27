package com.visualg.circlePacking;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CirclePacking extends Actor {

    private final ShapeRenderer sr;
    private final Circles circles;

    public CirclePacking() {
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        circles = new Circles();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        for (Circle circle : circles.getCircles()) {
            sr.circle(circle.x, circle.y, (float) circle.r);
        }
        sr.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        Circle circle = circles.getCircles().get(0);
        sr.circle(circle.x, circle.y, (float) circle.r);
        sr.end();
        batch.begin();
        circles.update();
    }

}
