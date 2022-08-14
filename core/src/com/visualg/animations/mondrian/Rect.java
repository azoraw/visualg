package com.visualg.animations.mondrian;

import com.badlogic.gdx.graphics.Color;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
class Rect {
    int x;
    int y;
    int width;
    int height;
    Color color;
}
