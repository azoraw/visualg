package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.visualg.animations.Animation;
import com.visualg.util.color.PaletteType;
import lombok.Getter;
import lombok.Setter;

public class Config {

    @Setter
    public static int updatesPerFrame = 1;
    public static int WIDTH;
    public static int HEIGHT;
    public static Skin skin;
    @Getter @Setter
    private static Animation currentAnimation;

    @Setter
    public static PaletteType palette = PaletteType.DARK;

    public static void init() {
        initSkin();
        initNativeResolution();
    }

    private static void initSkin() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    private static void initNativeResolution() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
    }
}
