package com.visualg.animations.spiral.ulam;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.animations.spiral.Position;
import com.visualg.util.libgdx.PixmapAlg;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static java.lang.Math.max;

public class UlamSpiralAlg extends PixmapAlg {

    public static final int SIDE_LENGTH = max(WIDTH, HEIGHT);
    private final Prime prime;

    public UlamSpiralAlg() {
        prime = new Prime();
    }

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
            int pixelColor = prime.isPrime(number) ? Color.WHITE.toIntBits() : Color.BLACK.toIntBits();
            img.drawPixel(currentPosition.getX(), currentPosition.getY(), pixelColor);
        }
    }

}
