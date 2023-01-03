package com.visualg.animations.kandynsky;

import lombok.Data;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();

    private EditMode editMode = EditMode.CREATE;
    private Shape shape = Shape.CIRCLE;
    private boolean drawBackground = true;
    private Element selectedElement = null;
    private boolean rotate = false;
}
