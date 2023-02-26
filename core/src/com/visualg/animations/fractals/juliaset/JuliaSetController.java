package com.visualg.animations.fractals.juliaset;

import com.visualg.ui.pixmap.PixmapActor;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
class JuliaSetController {

    private final JuliaSetSettings juliaSetSettings;
    private final Table table;
    private final PixmapActor juliaSetActor;

    void zoom(Zoom zoom) {
        juliaSetSettings.zoom(zoom);
        updateViews();
    }

    void moveCameraAndZoom(int screenX, int screenY, Zoom zoom) {
        juliaSetSettings.move(screenX, screenY, WIDTH, HEIGHT);
        juliaSetSettings.zoom(zoom);
        updateViews();
    }

    void moveCamera(Direction direction) {
        juliaSetSettings.addOffset(direction);
        updateViews();
    }

    void moveCamera(int screenX, int screenY) {
        juliaSetSettings.move(screenX, screenY, WIDTH, HEIGHT);
        updateViews();
    }

    void moveSet(Direction left) {
        juliaSetSettings.moveJulia(left);
        updateViews();
    }

    private void updateViews() {
        table.updateFields();
        juliaSetActor.asyncUpdate();
    }
}
