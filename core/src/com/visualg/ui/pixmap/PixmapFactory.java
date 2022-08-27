package com.visualg.ui.pixmap;

import com.badlogic.gdx.graphics.Pixmap;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;

public class PixmapFactory {
    public static Pixmap create() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(palette.getBackground());
        pixmap.fill();
        return pixmap;
    }
}
