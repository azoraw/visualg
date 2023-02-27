package com.visualg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.visualg.Visualg;

public class DesktopLauncher {

    private static final boolean debug = false;

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        if (debug) {
            updateWindowSize(config);
        } else {
            setFullScreenMode(config);
        }
        new LwjglApplication(new Visualg(), config);
    }

    private static void setFullScreenMode(LwjglApplicationConfiguration config) {
        config.setFromDisplayMode(com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration.getDesktopDisplayMode());
    }

    private static void updateWindowSize(LwjglApplicationConfiguration config) {
        config.width = 2000;
        config.height = 1000;
    }
}
