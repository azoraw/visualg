package com.visualg;

import com.badlogic.gdx.graphics.Pixmap;

import java.util.function.Supplier;

class RandomPixMap {

    Pixmap generatePixMap(int WIDTH, int HEIGHT, Supplier<Integer> color) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                pixmap.drawPixel(i, j, color.get());
            }
        }
        return pixmap;
    }
}
