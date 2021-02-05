package com.visualg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Visualg extends ApplicationAdapter {

    private SpriteBatch batch;
    private int WIDTH;
    private int HEIGHT;
    private RandomPixMap randomPixMap;

    @Override
    public void create() {
        batch = new SpriteBatch();
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        randomPixMap = new RandomPixMap();
    }

    @Override
    public void render() {
        refreshCanvas();
        batch.begin();
        Pixmap pixmap = randomPixMap.generatePixMap(WIDTH, HEIGHT);
        Texture texture = new Texture(pixmap);
        batch.draw(texture, 0, 0);
        batch.end();
        texture.dispose();
        pixmap.dispose();
    }


    private void refreshCanvas() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
