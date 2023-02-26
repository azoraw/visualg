package com.visualg.animations.fractals.multibrot;

import com.visualg.ui.pixmap.PixmapActor;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
class MultibrotSetController {

    private final MultibrotSettings multibrotSettings;
    private final Table table;
    private final PixmapActor multibrotActor;

    void zoom(Zoom zoom) {
        multibrotSettings.zoom(zoom);
        updateViews();
    }

    void moveCameraAndZoom(int screenX, int screenY, Zoom zoom) {
        multibrotSettings.move(screenX, screenY, WIDTH, HEIGHT);
        multibrotSettings.zoom(zoom);
        updateViews();
    }

    void moveCamera(Direction direction) {
        multibrotSettings.addOffset(direction);
        updateViews();
    }

    void moveCamera(int screenX, int screenY) {
        multibrotSettings.move(screenX, screenY, WIDTH, HEIGHT);
        updateViews();
    }

    void moveSet(Direction left) {
        multibrotSettings.moveSet(left);
        updateViews();
    }

    private void updateViews() {
        table.updateFields();
        multibrotActor.asyncUpdate();
    }
}
