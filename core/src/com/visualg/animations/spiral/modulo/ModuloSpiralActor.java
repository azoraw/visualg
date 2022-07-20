package com.visualg.animations.spiral.modulo;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ModuloSpiralActor extends Actor {

    private final ModuloSpiralAlg alg;
    private Texture texture;
    private Pixmap pixmap;

    public ModuloSpiralActor(ModuloSpiralAlg alg) {
        this.alg = alg;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        pixmap = alg.getPixMap();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
        alg.update();
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

