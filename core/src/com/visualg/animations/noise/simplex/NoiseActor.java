package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

public class NoiseActor extends Actor {

    private final SimplexPixMap simplexPixMap;
    private Texture texture;
    private Pixmap pixmap;

    public NoiseActor(NoiseSettings settings) {
        simplexPixMap = new SimplexPixMap(settings);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        pixmap = simplexPixMap.generateMovementOnZAxis();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0, Config.WIDTH, Config.HEIGHT);
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
