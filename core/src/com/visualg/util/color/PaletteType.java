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


    @Getter
    @Setter
    private Color primaryColor;
    @Getter
    @Setter
    private Color secondaryColor;
    @Getter
    @Setter
    private Color background;

    @Setter
    private static Runnable onPrimaryColorChange;
    @Setter
    private static Runnable onSecondaryColorChange;
    @Setter
    private static Runnable onBackgroundColorChange;

    public static void updateUserPrimaryColor(Color userPrimaryColor) {
        onPrimaryColorChange.run();
        USER_DEFINED.setPrimaryColor(userPrimaryColor.cpy());
    }

    public static void updateUserSecondaryColor(Color userSecondaryColor) {
        onSecondaryColorChange.run();
        USER_DEFINED.setSecondaryColor(userSecondaryColor.cpy());
    }

    public static void updateUserBackgroundColor(Color userBackgroundColor) {
        onBackgroundColorChange.run();
        USER_DEFINED.setBackground(userBackgroundColor.cpy());
    }

}
