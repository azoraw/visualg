package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.global.Config;
import com.visualg.util.OpenSimplexNoise;

import java.util.function.Function;

import static com.visualg.animations.noise.simplex.SimplexSettings.settings;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;


class SimplexPixMap {

    private final double X_OFF;
    private final double Y_OFF;
    private final double Z_OFF;

    private final int WIDTH_SCALED = WIDTH / 2;
    private final int HEIGHT_SCALED = HEIGHT / 2;

    private final OpenSimplexNoise openSimplex;
    private final Function<Double, Integer> colorFunction;
    private final int goInNumberOfPixels;
    private final Pixmap pixmap;
    private double z;

    SimplexPixMap() {
        goInNumberOfPixels = settings.getNumberOfSkippedPixels();
        openSimplex = new OpenSimplexNoise(0);
        colorFunction = settings.getColorMode().getColorFunction();
        X_OFF = settings.getX_OFF();
        Y_OFF = settings.getY_OFF();
        Z_OFF = settings.getZ_OFF();
        pixmap = new Pixmap(WIDTH_SCALED, HEIGHT_SCALED, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(palette.getPrimaryColor());
    }

    Pixmap generateMovementOnZAxis() {
        double x = 0;
        double y;
        for (int i = 0; i < WIDTH_SCALED; i += goInNumberOfPixels) {
            y = 0;
            for (int j = 0; j < HEIGHT_SCALED; j += goInNumberOfPixels) {
                double eval = openSimplex.eval(x, y, z);
                pixmap.drawPixel(i, j, colorFunction.apply(eval));
                y += Y_OFF;
            }
            x += X_OFF;
        }
        z += Z_OFF * Config.updatesPerFrame;
        return pixmap;
    }
}
