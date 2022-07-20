package com.visualg.util.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.util.libgdx.ui.ProgressBarActor;

public class PixmapActor extends Group {

    private final PixmapAlg alg;
    private final ProgressBarActor progressBarActor = new ProgressBarActor(10, 30, 1000, 200);
    private Sprite sprite;

    public PixmapActor(PixmapAlg alg) {
        this.alg = alg;
        update();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (sprite != null) {
            sprite.draw(batch);
        }
        if (progressBarActor.isShown()) {
            progressBarActor.getProgressBar().setValue(alg.progress);
        }
        this.drawChildren(batch, parentAlpha);
    }

    public void update() {
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
}
