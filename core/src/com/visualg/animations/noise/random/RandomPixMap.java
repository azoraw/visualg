package com.visualg.animations.noise.random;

import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.util.RandomColorGenerator;

import java.util.function.Supplier;

import static com.badlogic.gdx.graphics.Pixmap.Blending.None;
import static com.visualg.animations.noise.random.ColorModeSupplierFactory.getColorMode;

public class RandomPixMap {

    private final Supplier<Integer> colorSupplier;

    public RandomPixMap(RandomColorMode mode) {
        RandomColorGenerator randomColorGenerator = new RandomColorGenerator();
        colorSupplier = getColorMode(mode, randomColorGenerator);
    }

    public Pixmap generatePixMap(int WIDTH, int HEIGHT) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(None);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                pixmap.drawPixel(i, j, colorSupplier.get());
            }
        }
        return pixmap;
    }
}
