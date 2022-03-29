package com.visualg.animations.noise;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.visualg.animations.noise.random.RandomColorMode;
import com.visualg.animations.noise.random.RandomPixMap;
import com.visualg.animations.noise.simplex.SimplexColorMode;
import com.visualg.animations.noise.simplex.SimplexPixMap;

public class Noise extends ApplicationAdapter {

    private SpriteBatch batch;
    private RandomPixMap randomPixMap;
    private SimplexPixMap simplexPixMap;

    @Override
    public void create() {
        batch = new SpriteBatch();
        int WIDTH = Gdx.graphics.getWidth();
        int HEIGHT = Gdx.graphics.getHeight();
        randomPixMap = new RandomPixMap(RandomColorMode.RANDOM);
        simplexPixMap = new SimplexPixMap(WIDTH, HEIGHT, SimplexColorMode.BLACK_AND_WHITE, 1);
    }

    @Override
    public void render() {
        refreshCanvas();
        batch.begin();
        //Pixmap pixmap = randomPixMap.generatePixMap(WIDTH, HEIGHT);
        Pixmap pixmap = simplexPixMap.generateZoomOut();
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
