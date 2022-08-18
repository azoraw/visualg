package com.visualg.animations.spiral.modulo;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.animations.spiral.Position;
import com.visualg.ui.pixmap.PixmapAlg;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static java.lang.Math.max;

class ModuloSpiralAlg extends PixmapAlg {

    static final int SIDE_LENGTH = max(WIDTH, HEIGHT);
    private int modulo = 1;

    @Override
    public Pixmap getPixMap() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setBlending(Pixmap.Blending.None);
        Position currentPosition = new Position();
        int number = 1;

        while (imageIsNotColored(number)) {
            colorPixel(pixmap, currentPosition, number);
            currentPosition.move();
            currentPosition.turn();
            number++;
        }
        return pixmap;
    }

    private boolean imageIsNotColored(int number) {
        return number <= SIDE_LENGTH * (SIDE_LENGTH + 1);
    }

    private void colorPixel(Pixmap img, Position currentPosition, int number) {
        if (currentPosition.isInsideDrawableArea()) {
            int pixelColor = number % modulo == 0 ? Color.WHITE.toIntBits() : Color.BLACK.toIntBits();
            img.drawPixel(currentPosition.getX(), currentPosition.getY(), pixelColor);
        }
    }

    void update() {
        modulo++;
    }
}
