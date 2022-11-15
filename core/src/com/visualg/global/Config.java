package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.visualg.animations.Animation;
import com.visualg.util.color.PaletteType;
import com.visualg.util.libgdx.RefreshType;
import lombok.Getter;
import lombok.Setter;

import static com.visualg.util.color.PaletteType.USER_DEFINED;

public class Config {

    @Setter
    public static int updatesPerFrame = 1;
    public static int WIDTH = 1920;
    public static int HEIGHT = 1080;
    public static RefreshType refreshType = RefreshType.DEFAULT;
    public static Skin skin;
    @Setter
    @Getter
    private static Animation currentAnimation;

    @Setter
    public static PaletteType palette = PaletteType.DARK;

    @Getter
    private static Color userPrimaryColor = palette.getPrimaryColor();
    @Setter
    private static Runnable onPrimaryColorChange;
    @Getter
    private static Color userSecondaryColor = palette.getPrimaryColor();
    @Setter
    private static Runnable onSecondaryColorChange;
    @Getter
    private static Color userBackgroundColor = palette.getBackground();
    @Setter
    private static Runnable onBackgroundColorChange;

    public static void updateUserPrimaryColor(Color userPrimaryColor) {
        Config.userPrimaryColor = userPrimaryColor;
        onPrimaryColorChange.run();
        USER_DEFINED.setPrimaryColor(userPrimaryColor.cpy());
    }

    public static void updateUserSecondaryColor(Color userSecondaryColor) {
        Config.userSecondaryColor = userSecondaryColor;
        onSecondaryColorChange.run();
    }

    public static void updateUserBackgroundColor(Color userBackgroundColor) {
        Config.userBackgroundColor = userBackgroundColor;
        onBackgroundColorChange.run();
        USER_DEFINED.setBackground(userBackgroundColor.cpy());
    }

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
