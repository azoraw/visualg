package com.visualg.util.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class PixmapFactory {
    public static Pixmap create() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        return pixmap;
    }
}
