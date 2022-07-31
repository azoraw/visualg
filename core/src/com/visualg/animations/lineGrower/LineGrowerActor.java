package com.visualg.animations.lineGrower;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

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
        alg.update();
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
