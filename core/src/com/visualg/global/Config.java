package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.visualg.animations.Animation;
import com.visualg.controls.MusicController;
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
    private static float uiScale = 1f;
    @Getter @Setter
    private static Animation currentAnimation;

    @Setter
    public static PaletteType palette = PaletteType.DARK;
    public static MusicController musicController;

    public static void init() {
        initSkin();
        initNativeResolution();
        initMusic();
    }

    private static void initMusic() {
        musicController = new MusicController();
    }

    private static void initSkin() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        updateUiFontScale(uiScale);
    }

    public static void updateUiFontScale(float newUiScale) {
        uiScale = newUiScale;
        skin.getFont("default-font").getData().setScale(newUiScale);
    }

    private static void initNativeResolution() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
    }
}
