package com.visualg.animations.nBody;

import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;

import static com.visualg.animations.nBody.NBodySettings.settings;

class TransparentNBodyActor extends FrameBufferActor {
    private final NBodyAlg alg;

    TransparentNBodyActor(NBodyAlg alg) {
        super(true);
        this.alg = alg;
        final Color color = Config.palette.getPrimaryColor().cpy();
        color.a = settings.getTransparency();
        sr.setColor(color);
    }

    @Override
    protected void drawFrame() {
        for (Body body : alg.getBodies()) {
            sr.circle(body.getPosition().x, body.getPosition().y, 50);
        }
        alg.update();
    }
}

