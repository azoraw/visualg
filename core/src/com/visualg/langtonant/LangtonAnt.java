package com.visualg.langtonant;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LangtonAnt extends ApplicationAdapter {
    private SpriteBatch batch;

    private int WIDTH;
    private int HEIGHT;
    private LangtonAntAlg langtonAntAlg;


    @Override
    public void create() {
        batch = new SpriteBatch();
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        langtonAntAlg = new LangtonAntAlg(WIDTH, HEIGHT);
    }

    @Override
    public void render() {
        refreshCanvas();
        batch.begin();
        Pixmap pixmap = langtonAntAlg.getPixMap();
        Texture texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
        batch.end();
        texture.dispose();
        pixmap.dispose();

        langtonAntAlg.move();
    }

    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
