package com.visualg.animations.kandynsky;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private EditMode editMode = EditMode.SELECT;
    private Shape shape = Shape.CIRCLE;
    private boolean drawBackground = true;
    private Element selectedElement = null;
    private boolean rotate = false;
}
