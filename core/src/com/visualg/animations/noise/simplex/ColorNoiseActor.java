package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

public class ColorNoiseActor extends Actor {

    private final ColorPixMap simplexPixMap;
    private Texture texture;

    public ColorNoiseActor() {
        simplexPixMap = new ColorPixMap();
        texture = new Texture(simplexPixMap.getPixMap());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        texture = new Texture(simplexPixMap.getPixMap());
        batch.draw(texture, 0, 0, Config.WIDTH, Config.HEIGHT);
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            simplexPixMap.update();
        }
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
