package com.visualg.animations.fractals.juliaset;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.ui.pixmap.PixmapAlg;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
class JuliaSetAlg extends PixmapAlg {

    private final JuliaSetSettings juliaSetSettings;

    @Override
    public Pixmap getPixMap() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setBlending(Pixmap.Blending.None);

        double cRe = juliaSetSettings.getComplexNumber().re();
        double cIm = juliaSetSettings.getComplexNumber().im();

        double prevRe;
        double prevIm;
        double xOffset = juliaSetSettings.getXOffset();
        double yOffset = juliaSetSettings.getYOffset();
        double zoom = juliaSetSettings.getZoom();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                updateProgress(x, y);
                double nextRe = WIDTH / (float) HEIGHT * (x - WIDTH / 2d) / (WIDTH * 0.5 * zoom) - xOffset;
                double nextIm = (y - HEIGHT / 2d) / (HEIGHT * 0.5 * zoom) - yOffset;
                int p;
                for (p = 0; p < juliaSetSettings.getNumberOfIteration(); p++) {
                    prevRe = nextRe;
                    prevIm = nextIm;
                    nextRe = prevRe * prevRe - prevIm * prevIm + cRe;
                    nextIm = 2 * prevRe * prevIm + cIm;
                    if ((nextRe * nextRe + nextIm * nextIm) > 4) {
                        break;
                    }
                }
                int color = Color.rgba8888(getRgbPart(juliaSetSettings, p, juliaSetSettings.getRMultiplier()),
                        getRgbPart(juliaSetSettings, p, juliaSetSettings.getGMultiplier()),
                        getRgbPart(juliaSetSettings, p, juliaSetSettings.getBMultiplier()),
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

    private float getRgbPart(JuliaSetSettings juliaSetSettings, int p, int multiplier) {
        float v = (float) (p * multiplier) / juliaSetSettings.getNumberOfIteration();
        return v - (int) v;
    }

}
