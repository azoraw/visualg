package com.visualg.animations.kandynsky;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class KandynskySettings implements Settings {
    static final KandynskySettings settings = new KandynskySettings();

    private EditMode editMode = EditMode.SELECT;
    private Shape shape = Shape.CIRCLE;
    private boolean drawBackground = true;
    private Element selectedElement = null;
    private boolean rotate = false;
}
