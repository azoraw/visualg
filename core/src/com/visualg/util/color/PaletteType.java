package com.visualg.util.color;

import com.badlogic.gdx.graphics.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.WHITE;

@AllArgsConstructor
public enum PaletteType {
    DARK(BLACK, WHITE),
    BRIGHT(WHITE, BLACK),
    USER_DEFINED(BLACK, WHITE);

    @Getter @Setter
    private Color background;
    @Getter @Setter
    private Color primaryColor;

}
