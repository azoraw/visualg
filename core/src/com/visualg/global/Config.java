package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Config {

    public static RefreshType refreshType = RefreshType.DEFAULT;
    public static Skin skin;

    public static void initSkin() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }
}
