package com.visualg.animations.fractals.juliaset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

public class JuliaSetActor extends Actor {

    private final JuliaSetAlg alg;
    private Texture texture;

    public JuliaSetActor(Settings settings) {
        alg = new JuliaSetAlg(settings);
        texture = new Texture(alg.getPixMap());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        texture = new Texture(alg.getPixMap());
        batch.draw(texture, 0, 0, Config.WIDTH, Config.HEIGHT);
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
