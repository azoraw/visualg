package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.global.Config;
import com.visualg.util.OpenSimplexNoise;

public class ColorPixMap {

    private static final double X_OFF = 0.01;
    private static final double Y_OFF = 0.01;
    private static final double Z_OFF = 0.04;

    private static final int WIDTH_SCALED = Config.WIDTH / 4;
    private static final int HEIGHT_SCALED = Config.HEIGHT / 4;
    private final OpenSimplexNoise openSimplex;
    private final Pixmap pixmap;
    private double z;

    public ColorPixMap() {
        openSimplex = new OpenSimplexNoise(0);
        pixmap = new Pixmap(WIDTH_SCALED, HEIGHT_SCALED, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);
    }

    public Pixmap getPixMap() {
        double x = 0;
        double y;
        for (int i = 0; i < WIDTH_SCALED; i++) {
            y = 0;
            for (int j = 0; j < HEIGHT_SCALED; j++) {
                float r = (float) (openSimplex.eval(x, y, z) + 1) / 2;
                float g = (float) (openSimplex.eval(x, y, z + 100) + 1) / 2;
                float b = (float) (openSimplex.eval(x, y, z + 200) + 1) / 2;
                pixmap.drawPixel(i, j, Color.rgba8888(r, g, b, 1));
                y += Y_OFF;
            }
            x += X_OFF;
        }
        z += Z_OFF;
        return pixmap;
    }
}
