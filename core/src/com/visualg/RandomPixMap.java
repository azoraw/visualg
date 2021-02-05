package com.visualg;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.Random;

class RandomPixMap {

    private final Random random = new Random();

    Pixmap generatePixMap(int WIDTH, int HEIGHT) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                pixmap.setColor(new Color(random.nextInt()));
                pixmap.drawPixel(i, j);
            }
        }
        return pixmap;
    }
}
