package com.visualg.animations.fractals.juliaset;

import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
public class JuliaSetController {

    private final Settings settings;

    public void zoom(Zoom zoom) {
        settings.zoom(zoom);
    }

    public void moveCameraAndZoom(int screenX, int screenY, Zoom zoom) {
        settings.move(screenX, screenY, WIDTH, HEIGHT);
        settings.zoom(zoom);
    }

    public void moveCamera(Direction direction) {
        settings.addOffset(direction);
    }

    public void moveCamera(int screenX, int screenY) {
        settings.move(screenX, screenY, WIDTH, HEIGHT);
    }

    public void moveSet(Direction left) {
        settings.moveJulia(left);
    }
}
