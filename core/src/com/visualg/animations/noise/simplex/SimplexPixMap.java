package com.visualg.animations.noise.simplex;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.util.OpenSimplexNoise;

import java.util.function.Function;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;


public class SimplexPixMap {

    private static final double X_OFF = 0.14;
    private static final double Y_OFF = 0.14;
    private static final double Z_OFF = 0.04;

    private final int WIDTH_SCALED = WIDTH / 2;
    private final int HEIGHT_SCALED = HEIGHT / 2;

    private final OpenSimplexNoise openSimplex;
    private final Function<Double, Integer> colorFunction;
    private final int goInNumberOfPixels;
    private final Pixmap pixmap;
    private double z;

    public SimplexPixMap(SimplexColorMode mode, int goInNumberOfPixels) {
        this.goInNumberOfPixels = goInNumberOfPixels;
        openSimplex = new OpenSimplexNoise(0);
        colorFunction = mode.getColorFunction();
        pixmap = new Pixmap(WIDTH_SCALED, HEIGHT_SCALED, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);
    }

    public Pixmap generateMovementOnZAxis() {
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
        z += Z_OFF;
        return pixmap;
    }

    public Pixmap generateZoomOut() {
        double x = 0;
        double y;
        for (int i = 0; i < WIDTH_SCALED; i += goInNumberOfPixels) {
            y = 0;
            for (int j = 0; j < HEIGHT_SCALED; j += goInNumberOfPixels) {
                double eval = openSimplex.eval(x, y, 0);
                pixmap.drawPixel(i, j, colorFunction.apply(eval));
                y += Y_OFF + z;
            }
            x += X_OFF + z;
        }
        z += Z_OFF;
        return pixmap;
    }

    public Pixmap generatePlanarMovement() {
        double x = z;
        double y;
        for (int i = 0; i < WIDTH_SCALED; i += goInNumberOfPixels) {
            y = z;
            for (int j = 0; j < HEIGHT_SCALED; j += goInNumberOfPixels) {
                double eval = openSimplex.eval(x, y, 0);
                pixmap.drawPixel(i, j, colorFunction.apply(eval));
                y += Y_OFF;
            }
            x += X_OFF;
        }
        z += Z_OFF;
        return pixmap;
    }

}
