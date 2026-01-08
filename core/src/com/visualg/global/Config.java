package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.visualg.animations.Animation;
import com.visualg.controls.MusicController;
import com.visualg.controls.fileio.UserProperties;
import com.visualg.util.color.PaletteType;
import lombok.Getter;
import lombok.Setter;

public class Config {

    @Setter
    public static int updatesPerFrame = 1;
    public static int WIDTH;
    public static int HEIGHT;
    public static Skin skin;
    @Setter
    public static PaletteType palette = PaletteType.USER_DEFINED;
    public static MusicController musicController;
    @Getter
    @Setter
    private static Animation currentAnimation;
    @Getter
    private static UserProperties userProperties;

    public static void init() {
        initUserProperties();
        initSkin();
        //initNativeResolution();
        initBigResolution();
        initMusic();
    }

    private static void initUserProperties() {
        userProperties = new UserProperties();
    }

    private static void initMusic() {
        musicController = new MusicController();
    }

    private static void initNativeResolution() {
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
    }

    private static void initBigResolution() {
        WIDTH = 8270/2;
        HEIGHT = 5900/2;
    }

    private static void initSkin() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        updateUiFontScale(userProperties.getUiScale());
    }

    public static void updateUiFontScale(float newUiScale) {
        skin.getFont("default-font").getData().setScale(newUiScale);
        userProperties.saveUiScale(newUiScale);
    }


}
