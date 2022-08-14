package com.visualg.animations.lineGrower;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class LineGrowerActor extends Actor {
    private final LineGrowerAlg alg;
    private Texture texture;

    public LineGrowerActor(LineGrowerAlg alg) {
        this.alg = alg;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        texture = new Texture(alg.getPixMap());
        batch.draw(texture, 0, 0, WIDTH, HEIGHT, 0, 0, WIDTH, HEIGHT, false, true);
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            alg.update();
        }
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
