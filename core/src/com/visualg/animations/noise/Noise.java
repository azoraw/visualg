package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.noise.simplex.SimplexColorMode;
import com.visualg.animations.noise.simplex.SimplexPixMap;

public class Noise extends Actor {

    private SimplexPixMap simplexPixMap;
    private Texture texture;
    private Pixmap pixmap;

    public Noise() {
        simplexPixMap = new SimplexPixMap(SimplexColorMode.GRAYSCALE, 1);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        pixmap = simplexPixMap.generateMovementOnZAxis();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
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
