package com.visualg.animations.fractals.mandelbrot;

import com.visualg.ui.pixmap.PixmapActor;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
class MandelbrotController {

    private final Settings settings;
    private final SettingsView settingsView;
    private final PixmapActor mandelbrotActor;

    void zoom(Zoom zoom) {
        settings.zoom(zoom);
        updateViews();
    }

    void moveCameraAndZoom(int screenX, int screenY, Zoom zoom) {
        settings.move(screenX, screenY, WIDTH, HEIGHT);
        settings.zoom(zoom);
        updateViews();
    }

    void moveCamera(Direction direction) {
        settings.addOffset(direction);
        updateViews();
    }

    void moveCamera(int screenX, int screenY) {
        settings.move(screenX, screenY, WIDTH, HEIGHT);
        updateViews();
    }

    private void updateViews() {
        settingsView.updateFields();
        mandelbrotActor.asyncUpdate();
    }
}
