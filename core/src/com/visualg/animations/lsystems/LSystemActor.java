package com.visualg.animations.lsystems;


import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.turtleGraphics.TurtleGraphicRenderer;

import static com.visualg.animations.lsystems.LSystemSettings.LSystemSettings;

class LSystemActor extends TurtleGraphicRenderer {

    private final String out;
    private int index = 0;

    LSystemActor() {
        super(LSystemSettings.xStart, LSystemSettings.yStart, LSystemSettings.angleStart);
        final LSystemAlg lSystemAlg = new LSystemAlg();
        out = lSystemAlg.create(LSystemSettings.numberOfGenerations);
        final Color cpy = Config.palette.getPrimaryColor().cpy();
        cpy.a = LSystemSettings.transparency;
        sr.setColor(cpy);
    }

    @Override
    protected void drawFrame() {
        if (index < out.length()) {
            char c = out.charAt(index);
            switch (c) {
                case 'A', 'B', 'F', 'G' -> move(LSystemSettings.distance);
                case '+' -> rotate(LSystemSettings.rotateLeft);
                case '-' -> rotate(LSystemSettings.rotateRight);
                case '[' -> pushState();
                case ']' -> popState();
            }
            index++;
        }
    }
}
