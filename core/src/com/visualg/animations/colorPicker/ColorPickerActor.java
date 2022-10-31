package com.visualg.animations.colorPicker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class ColorPickerActor extends Actor {

    private final ColorPickerAlg colorPickerAlg;
    private Texture texture;
    private final ShapeRenderer sr;


    ColorPickerActor(ColorPickerAlg colorPickerAlg) {
        this.colorPickerAlg = colorPickerAlg;
        sr = new ShapeRenderer();
        sr.setColor(Color.BLACK);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        disposePreviousTexture();
        texture = new Texture(colorPickerAlg.getPixmap());
        batch.draw(texture, 0, 0, WIDTH, HEIGHT, 0, 0, WIDTH, HEIGHT, false, true);
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.circle(colorPickerAlg.getHuePosition().first(), colorPickerAlg.getHuePosition().second(), 20);
        sr.circle(colorPickerAlg.getValueAndSaturationPosition().first(), colorPickerAlg.getValueAndSaturationPosition().second(), 20);
        sr.end();
        batch.begin();
    }

    private void disposePreviousTexture() {
        if (texture != null) {
            texture.dispose();
        }
    }

}
