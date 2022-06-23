package com.visualg.util.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;

import java.time.LocalDateTime;

public class ScreenShotUtil {

    public static void take(Pixmap pixmap) {
        PixmapIO.writePNG(Gdx.files.local(getName()), pixmap);
        pixmap.dispose();
    }

    private static String getName() {
        return "screenShots/"
                + LocalDateTime.now().toString()
                .replace("-", "_")
                .replace(":", "_")
                + ".png";
    }
}
