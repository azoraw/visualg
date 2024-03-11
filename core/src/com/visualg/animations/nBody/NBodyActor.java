package com.visualg.animations.nBody;

import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;

class NBodyActor extends ShapeRendererActor {

    private final NBodyAlg alg;

    NBodyActor(NBodyAlg alg) {
        super(Filled);
        this.alg = alg;
        sr.setColor(Config.palette.getPrimaryColor());
    }

    @Override
    protected void drawFrame() {
        for (Body body : alg.getBodies()) {
            sr.setColor(Config.palette.getPrimaryColor());
            sr.rect(body.getPosition().x, body.getPosition().y, 2, 2);
/*            sr.setColor(Config.palette.getSecondaryColor());
            sr.circle(body.getPosition().x, body.getPosition().y, 45);*/
        }
        alg.update();
    }
}
