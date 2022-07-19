package com.visualg.animations.fractals.juliaset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.util.libgdx.ui.ProgressBarActor;

public class JuliaSetActor extends Group {

    private final JuliaSetAlg alg;
    private final ProgressBarActor progressBarActor = new ProgressBarActor(10, 30, 1000, 200);
    private Texture texture;
    private Sprite sprite;

    public JuliaSetActor(Settings settings) {
        alg = new JuliaSetAlg(settings);
        texture = new Texture(alg.getPixMap());
        updateFractal();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        if (sprite != null) {
            sprite.draw(batch);
        }
        if (progressBarActor.isShown()) {
            progressBarActor.getProgressBar().setValue(alg.progress);
        }
        this.drawChildren(batch, parentAlpha);
    }

    void updateFractal() {
        if (!progressBarActor.isShown()) {
            addProgressBarActor();
            new Thread(() -> {
                Pixmap pixmap = alg.getPixMap();
                Gdx.app.postRunnable(() -> {
                    sprite = new Sprite(new Texture(pixmap));
                    pixmap.dispose();
                    removeProgressBarActor(progressBarActor);
                });
            }).start();
        }
    }

    private void addProgressBarActor() {
        progressBarActor.setShown(true);
        this.addActor(progressBarActor.getProgressBar());
    }

    private void removeProgressBarActor(ProgressBarActor progressBarActor) {
        progressBarActor.setShown(false);
        this.removeActor(progressBarActor.getProgressBar());
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
