package com.visualg.animations.nBody;

import com.badlogic.gdx.graphics.Color;
import com.visualg.util.libgdx.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;

class NBodyActor extends ShapeRendererActor {

    private final NBodyAlg alg;

    public NBodyActor(NBodyAlg alg) {
        super(Filled);
        this.alg = alg;
        sr.setColor(Color.DARK_GRAY);
    }


    @Override
    protected void drawFrame() {
        for (Body body : alg.getBodies()) {
            sr.setColor(Color.DARK_GRAY);
            sr.circle(body.getPosition().x, body.getPosition().y, 50);
            sr.setColor(Color.GRAY);
            sr.circle(body.getPosition().x, body.getPosition().y, 45);
        }
        alg.update();
    }
}
