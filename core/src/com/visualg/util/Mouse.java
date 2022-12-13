package com.visualg.util;

import com.badlogic.gdx.Gdx;
import com.visualg.global.Config;

public class Mouse {
    public static int getX() {
        return Gdx.input.getX();
    }

    public static int getY() {
        return Config.HEIGHT - Gdx.input.getY();
    }
}
