package com.visualg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.visualg.langtonant.LangtonAnt;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());

        new LwjglApplication(new LangtonAnt(), config);
    }
}
