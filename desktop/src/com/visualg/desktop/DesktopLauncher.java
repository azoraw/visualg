package com.visualg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.visualg.Main;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
        //small(config);
        new LwjglApplication(new Main(), config);
    }

    private static void small(LwjglApplicationConfiguration config) {
        config.width= 2000;
        config.height= 1000;
    }
}
