package com.visualg.animations.spiral.modulo;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

class ModuloSpiralActor extends Actor {

    private final ModuloSpiralAlg alg;
    private Texture texture;
    private Pixmap pixmap;

    ModuloSpiralActor(ModuloSpiralAlg alg) {
        this.alg = alg;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        pixmap = alg.getPixMap();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            alg.update();
        }
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
        if (pixmap != null) {
            pixmap.dispose();
        }
    }
}

