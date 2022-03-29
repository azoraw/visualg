package com.visualg.animations.nBody;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

class NBodyActor extends Actor {

    private final ShapeRenderer sr;
    private final NBodyAlg alg;

    public NBodyActor(NBodyAlg alg) {
        this.alg = alg;
        sr = new ShapeRenderer();
        sr.setColor(Color.DARK_GRAY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (Body body : alg.getBodies()) {
            sr.setColor(Color.DARK_GRAY);
            sr.circle(body.getPosition().x, body.getPosition().y, 50);
            sr.setColor(Color.GRAY);
            sr.circle(body.getPosition().x, body.getPosition().y, 45);
        }
        sr.end();
        alg.update();
        batch.begin();
    }
}
