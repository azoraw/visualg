package com.visualg.util.color;

import com.badlogic.gdx.graphics.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.WHITE;

@RequiredArgsConstructor
public enum PaletteType {
    DARK(BLACK, WHITE),
    BRIGHT(WHITE, BLACK);
    //DEFINED_BY_USER(null);

    @Getter
    private final Color background;
    @Getter
    private final Color primaryColor;

}
