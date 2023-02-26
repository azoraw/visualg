package com.visualg.animations.lsystems;


import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.turtleGraphics.TurtleGraphicRenderer;

import static com.visualg.animations.lsystems.LSystemSettings.settings;

class LSystemActor extends TurtleGraphicRenderer {

    private final String out;
    private int index = 0;

    LSystemActor() {
        super(settings.xStart, settings.yStart, settings.angleStart);
        final LSystemAlg lSystemAlg = new LSystemAlg();
        out = lSystemAlg.create(settings.numberOfGenerations);
        final Color cpy = Config.palette.getPrimaryColor().cpy();
        cpy.a = settings.transparency;
        sr.setColor(cpy);
    }

    @Override
    protected void drawFrame() {
        if (index < out.length()) {
            char c = out.charAt(index);
            switch (c) {
                case 'A', 'B', 'F', 'G' -> move(settings.distance);
                case '+' -> rotate(settings.rotateLeft);
                case '-' -> rotate(settings.rotateRight);
                case '[' -> pushState();
                case ']' -> popState();
            }
            index++;
        }
    }
}
