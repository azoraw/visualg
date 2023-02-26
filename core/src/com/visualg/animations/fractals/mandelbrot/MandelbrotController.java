package com.visualg.animations.fractals.mandelbrot;

import com.visualg.ui.pixmap.PixmapActor;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
class MandelbrotController {

    private final MandelbrotSettings mandelbrotSettings;
    private final Table table;
    private final PixmapActor mandelbrotActor;

    void zoom(Zoom zoom) {
        mandelbrotSettings.zoom(zoom);
        updateViews();
    }

    void moveCameraAndZoom(int screenX, int screenY, Zoom zoom) {
        mandelbrotSettings.move(screenX, screenY, WIDTH, HEIGHT);
        mandelbrotSettings.zoom(zoom);
        updateViews();
    }

    void moveCamera(Direction direction) {
        mandelbrotSettings.addOffset(direction);
        updateViews();
    }

    void moveCamera(int screenX, int screenY) {
        mandelbrotSettings.move(screenX, screenY, WIDTH, HEIGHT);
        updateViews();
    }

    private void updateViews() {
        table.updateFields();
        mandelbrotActor.asyncUpdate();
    }
}
