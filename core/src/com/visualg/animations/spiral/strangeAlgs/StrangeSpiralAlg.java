package com.visualg.animations.spiral.strangeAlgs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.animations.spiral.Position;
import com.visualg.ui.pixmap.PixmapAlg;

import java.math.BigInteger;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;
import static java.lang.Math.max;

class StrangeSpiralAlg extends PixmapAlg {

    public static final int SIDE_LENGTH = max(WIDTH, HEIGHT);
    final Prime prime = new Prime();


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
            int pixelColor = isStrange(number) ? Color.rgba8888(palette.getPrimaryColor()) :  Color.rgba8888(palette.getBackground());
            img.drawPixel(currentPosition.getX(), currentPosition.getY(), pixelColor);
        }
    }

    private boolean isStrange(int number) {
return BigInteger.valueOf(number)
        .pow(4)
        .toString()
        .chars()
        .max()
        .getAsInt()
        //.sum()
        %2==0;

    }

}
