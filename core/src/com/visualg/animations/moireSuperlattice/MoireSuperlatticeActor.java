package com.visualg.animations.moireSuperlattice;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;
import com.visualg.util.color.ColorGenerator;

import static com.visualg.animations.moireSuperlattice.MoireSuperLatticeSettings.settings;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;

class MoireSuperlatticeActor extends Actor {
    private final SpriteBatch spriteBatch;
    private final TextureRegion textureRegion;
    private final TextureRegion textureRegion2;
    private float rotation = 0;

    MoireSuperlatticeActor() {
        spriteBatch = new SpriteBatch();

        Pixmap pixmap = getPixmap(settings.getColorOption());
        Pixmap pixmap2 = getPixmap(settings.getColorOption2());
        textureRegion = new TextureRegion(new Texture(pixmap));
        textureRegion2 = new TextureRegion(new Texture(pixmap2));
    }

    private Pixmap getPixmap(ColorOption colorOption) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(palette.getBackground());
        Color color=null;
        switch (colorOption) {
            case PRIMARY -> {
                color = Config.palette.getPrimaryColor().cpy();
                color.a = settings.getTransparency();
            }
            case RANDOM -> {
                color = new Color(ColorGenerator.getRandomColor());
                color.a = settings.getTransparency();
            }
        }
        for (int j = 0; j < WIDTH; j++) {
            for (int k = 0; k < HEIGHT; k++) {
                if (j % settings.getModuloX() == 0 && k % settings.getModuloY() == 0) {
                    if (colorOption == ColorOption.RANDOMS) {
                        color = new Color(ColorGenerator.getRandomColor());
                        color.a = settings.getTransparency();
                    }
                    pixmap.drawPixel(j, k, Color.rgba8888(color));
                }
            }
        }
        return pixmap;
    }

    public void draw(Batch batch, float parentAlpha) {
        spriteBatch.begin();
        spriteBatch.draw(textureRegion, 0, 0, Config.WIDTH / 2, Config.HEIGHT / 2, Config.WIDTH, Config.HEIGHT, 1, 1, 0);
        spriteBatch.draw(textureRegion2, 0, 0, Config.WIDTH / 2, Config.HEIGHT / 2, Config.WIDTH, Config.HEIGHT, 1, 1, rotation);
        rotation += settings.getRotationSpeed();
        spriteBatch.end();
    }
}
