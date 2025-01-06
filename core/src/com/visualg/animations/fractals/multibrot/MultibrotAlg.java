package com.visualg.animations.fractals.multibrot;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.ui.pixmap.PixmapAlg;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

@RequiredArgsConstructor
class MultibrotAlg extends PixmapAlg {

    private final MultibrotSettings multibrotSettings;

    @Override
    public Pixmap getPixMap() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setBlending(Pixmap.Blending.None);
        double pow, atan2;
        double xOffset = multibrotSettings.getXOffset();
        double yOffset = multibrotSettings.getYOffset();
        double zoom = multibrotSettings.getZoom();
        double multibrotPower = multibrotSettings.getMultibrotPower().re();

        float resolutionShapeAdjustment = WIDTH / (float) HEIGHT;

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                updateProgress(x, y);
                double re = resolutionShapeAdjustment * (x - WIDTH / 2d) / (WIDTH * 0.5 * zoom) - xOffset;
                double im = (y - HEIGHT / 2d) / (HEIGHT * 0.5 * zoom) - yOffset;
                double prevRe = 0;
                double prevIm = 0;
                double nextRe, nextIm;
                int p;
                for (p = 0; p < multibrotSettings.getNumberOfIteration(); p++) {
                    pow = pow((prevRe * prevRe + prevIm * prevIm), (multibrotPower / 2));
                    atan2 = atan2(prevIm, prevRe);
                    nextRe = pow * cos(multibrotPower * atan2) + re;
                    nextIm = pow * sin(multibrotPower * atan2) + im;
                    if (nextRe * nextRe + nextIm * nextIm > 4) {
                        break;
                    }
                    prevRe = nextRe;
                    prevIm = nextIm;
                }
                int color = Color.rgba8888(getRgbPart(multibrotSettings, p, multibrotSettings.getRMultiplier()),
                        getRgbPart(multibrotSettings, p, multibrotSettings.getGMultiplier()),
                        getRgbPart(multibrotSettings, p, multibrotSettings.getBMultiplier()),
                        1);
                if (p == 0) {
                    color = Color.rgba8888(Color.BLACK);
                }
                pixmap.drawPixel(x, y, color);
            }
        }
        return pixmap;
    }

    private void updateProgress(int x, int y) {
        progress = (x * HEIGHT + y) / (WIDTH * (float) HEIGHT);
    }

    private float getRgbPart(MultibrotSettings multibrotSettings, int p, int multiplier) {
        float v = (float) (p * multiplier) / multibrotSettings.getNumberOfIteration();
        return v - (int) v;
    }

}
