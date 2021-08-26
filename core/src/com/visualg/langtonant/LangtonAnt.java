package com.visualg.langtonant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LangtonAnt extends Actor {

    private final LangtonAntAlg langtonAntAlg;

    private Texture texture;
    private Pixmap pixmap;

    public LangtonAnt() {
        int WIDTH = Gdx.graphics.getWidth();
        int HEIGHT = Gdx.graphics.getHeight();
        langtonAntAlg = new LangtonAntAlg(WIDTH, HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        refreshCanvas();
        disposePreviousTexture();
        pixmap = langtonAntAlg.getPixMap();
        texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
        langtonAntAlg.move();
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
        if (pixmap != null) {
            pixmap.dispose();
        }
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
