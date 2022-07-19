package com.visualg.animations.fractals.juliaset;

import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

@RequiredArgsConstructor
public class JuliaSetController {

    private final Settings settings;
    private final SettingsView settingsView;

    public void zoom(Zoom zoom) {
        settings.zoom(zoom);
        settingsView.updateFields();
    }

    public void moveCameraAndZoom(int screenX, int screenY, Zoom zoom) {
        settings.move(screenX, screenY, WIDTH, HEIGHT);
        settings.zoom(zoom);
        settingsView.updateFields();
    }

    public void moveCamera(Direction direction) {
        settings.addOffset(direction);
        settingsView.updateFields();
    }

    public void moveCamera(int screenX, int screenY) {
        settings.move(screenX, screenY, WIDTH, HEIGHT);
        settingsView.updateFields();
    }

    public void moveSet(Direction left) {
        settings.moveJulia(left);
        settingsView.updateFields();
    }
}
