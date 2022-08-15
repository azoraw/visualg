package com.visualg.animations.mondrian;

import com.badlogic.gdx.graphics.Color;
import lombok.Builder;

record Rect(int x, int y, int width, int height, Color color) {
    @Builder public Rect {} //intellij bug: needs constructor
}
