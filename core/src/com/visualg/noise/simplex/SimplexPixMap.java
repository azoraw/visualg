package com.visualg.noise.simplex;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.noise.OpenSimplexNoise;

import java.util.function.Supplier;

public class SimplexPixMap {

    private static final double X_OFF = 0.02;
    private static final double Y_OFF = 0.02;
    private static final double Z_OFF = 0.02;
    private final OpenSimplexNoise openSimplex2S;
    private double eval;
    private double z;

    public SimplexPixMap() {
        openSimplex2S = new OpenSimplexNoise(0);
    }

    public Pixmap generatePixMap(int WIDTH, int HEIGHT, Supplier<Integer> colorMode) {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);

        double x = z;
        double y;
        for (int i = 0; i < WIDTH; i++) {
            y = 0;
            for (int j = 0; j < HEIGHT; j++) {
                eval = openSimplex2S.eval(x, y, z);
                pixmap.drawPixel(i, j, colorMode.get());
                y += Y_OFF;
            }
            x += X_OFF;
        }
        z += Z_OFF;
        return pixmap;
    }

     int getGreyScale() {
        return Color.rgba8888(1, 1, 1, (float) (eval + 1) / 2);
    }

    public int getCow() {
        return Color.rgba8888(1, 1, 1, eval > 0 ? 1 : 0);
    }
}
