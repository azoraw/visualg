package com.visualg.noise.simplex;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.function.Function;


public class SimplexPixMap {

    private static final double X_OFF = 0.02;
    private static final double Y_OFF = 0.02;
    private static final double Z_OFF = 0.001;

    private final int WIDTH;
    private final int HEIGHT;
    private final OpenSimplexNoise openSimplex2S;
    private final Function<Double, Integer> colorFunction;
    private final int goInNumberOfPixels;
    private double z;

    public SimplexPixMap(int WIDTH, int HEIGHT, SimplexColorMode mode, int goInNumberOfPixels) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.goInNumberOfPixels = goInNumberOfPixels;
        openSimplex2S = new OpenSimplexNoise(0);
        colorFunction = mode.getColorFunction();
    }

    public Pixmap generateMovementOnZAxis() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);

        double x = 0;
        double y;
        for (int i = 0; i < WIDTH; i+=goInNumberOfPixels) {
            y = 0;
            for (int j = 0; j < HEIGHT; j+=goInNumberOfPixels) {
                double eval = openSimplex2S.eval(x, y, z);
                pixmap.drawPixel(i, j, colorFunction.apply(eval));
                y += Y_OFF;
            }
            x += X_OFF;
        }
        z += Z_OFF;
        return pixmap;
    }

    public Pixmap generateZoomOut() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);

        double x = 0;
        double y;
        for (int i = 0; i < WIDTH; i+=goInNumberOfPixels) {
            y = 0;
            for (int j = 0; j < HEIGHT; j+=goInNumberOfPixels) {
                double eval = openSimplex2S.eval(x, y, 0);
                pixmap.drawPixel(i, j, colorFunction.apply(eval));
                y += Y_OFF + z;
            }
            x += X_OFF + z;
        }
        z += Z_OFF;
        return pixmap;
    }

    public Pixmap generatePlanarMovement() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);

        double x = z;
        double y;
        for (int i = 0; i < WIDTH; i+=goInNumberOfPixels) {
            y = z;
            for (int j = 0; j < HEIGHT; j+=goInNumberOfPixels) {
                double eval = openSimplex2S.eval(x, y, 0);
                pixmap.drawPixel(i, j, colorFunction.apply(eval));
                y += Y_OFF;
            }
            x += X_OFF;
        }
        z += Z_OFF;
        return pixmap;
    }

}
