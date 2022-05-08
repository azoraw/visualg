package com.visualg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.visualg.Main;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        //config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
        config.width = 1920;
        config.height = 1080;
        new LwjglApplication(new Main(), config);
    }
}
