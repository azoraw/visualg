package com.visualg.animations.langtonant;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;

public class LangtonAnt extends Actor {

    private final LangtonAntAlg langtonAntAlg;

    private Texture texture;
    private Pixmap pixmap;

    public LangtonAnt() {
        langtonAntAlg = new LangtonAntAlg();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        pixmap = langtonAntAlg.getPixMap();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
        for (int i = 0; i < Config.updatesPerFrame; i++) {
            langtonAntAlg.move();
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
