package com.visualg.animations.fractals.mandelbrot;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.animations.fractals.PixmapAlg;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
public class MandelbrotSetAlg extends PixmapAlg {

    private final Settings settings;

    @Override
    public Pixmap getPixMap() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setBlending(Pixmap.Blending.None);

        double xOffset = settings.getXOffset();
        double yOffset = settings.getYOffset();
        double zoom = settings.getZoom();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                updateProgress(x, y);
                double re = WIDTH / (float) HEIGHT * (x - (double) WIDTH / 2) / (WIDTH * 0.5 * zoom) - xOffset;
                double im = (y - (double) HEIGHT / 2) / (HEIGHT * 0.5 * zoom) - yOffset;
                double prevRe = 0;
                double prevIm = 0;
                double nextRe, nextIm;
                int p;
                for (p = 0; p < settings.getNumberOfIteration(); p++) {
                    nextRe = prevRe * prevRe - prevIm * prevIm + re;
                    nextIm = 2 * prevRe * prevIm + im;
                    if (nextRe * nextRe + nextIm * nextIm > 4) {
                        break;
                    }
                    prevRe = nextRe;
                    prevIm = nextIm;
                }
                int color = Color.rgba8888(getRgbPart(settings, p, settings.getRMultiplier()),
                        getRgbPart(settings, p, settings.getGMultiplier()),
                        getRgbPart(settings, p, settings.getBMultiplier()),
                        1);
                if (p == 0) {
                    color = Color.rgba8888(Color.BLACK);
                }
                pixmap.drawPixel(x, y, color);
            }
        }
        return pixmap;
    }

    private float getRgbPart(Settings settings, int p, int multiplier) {
        float v = (float) (p * multiplier) / settings.getNumberOfIteration();
        return v - (int) v;
    }

    private void updateProgress(int x, int y) {
        progress = (x * HEIGHT + y) / (WIDTH * (float) HEIGHT);
    }

}
