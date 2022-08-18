package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.visualg.util.libgdx.RefreshType;
import lombok.Setter;

public class Config {

    @Setter
    public static int updatesPerFrame = 1;
    public static int WIDTH = 1920;
    public static int HEIGHT = 1080;
    public static RefreshType refreshType = RefreshType.DEFAULT;
    public static Skin skin;

    public static void init() {
        initSkin();
        initResolution();
    }

    private static void initSkin() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    private static void initResolution() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
    }
}
