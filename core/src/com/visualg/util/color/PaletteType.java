package com.visualg.util.color;

import com.badlogic.gdx.graphics.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.WHITE;

@AllArgsConstructor
public enum PaletteType {
    BRIGHT(BLACK, BLACK, WHITE),
    DARK(WHITE, WHITE, BLACK),
    USER_DEFINED(WHITE, WHITE, BLACK);

    @Setter
    private static Runnable onPrimaryColorChange;
    @Setter
    private static Runnable onSecondaryColorChange;
    @Setter
    private static Runnable onBackgroundColorChange;
    @Getter
    private Color primaryColor;
    @Getter
    private Color secondaryColor;
    @Getter
    private Color background;

    public static void updateUserPrimaryColor(Color userPrimaryColor) {
        USER_DEFINED.primaryColor = userPrimaryColor.cpy();
        onPrimaryColorChange.run();
    }

    public static void updateUserSecondaryColor(Color userSecondaryColor) {
        USER_DEFINED.secondaryColor = userSecondaryColor.cpy();
        onSecondaryColorChange.run();
    }

    public static void updateUserBackgroundColor(Color userBackgroundColor) {
        USER_DEFINED.background = userBackgroundColor.cpy();
        onBackgroundColorChange.run();
    }
}
