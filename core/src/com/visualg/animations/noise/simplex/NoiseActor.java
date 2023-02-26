package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

class NoiseActor extends Actor {

    private final SimplexPixMap simplexPixMap;
    private Texture texture;

    NoiseActor(SimplexSettings simplexSettings) {
        simplexPixMap = new SimplexPixMap(simplexSettings);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        Pixmap pixmap = simplexPixMap.generateMovementOnZAxis();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0, Config.WIDTH, Config.HEIGHT);
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
