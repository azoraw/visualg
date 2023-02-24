package com.visualg.animations.lsystems;


import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.turtleGraphics.TurtleGraphicRenderer;

import static com.visualg.animations.lsystems.Settings.Settings;

class LSystemActor extends TurtleGraphicRenderer {

    private final String out;
    private int index = 0;

    LSystemActor() {
        super(Settings.xStart, Settings.yStart, Settings.angleStart);
        final LSystemAlg lSystemAlg = new LSystemAlg();
        out = lSystemAlg.create(Settings.numberOfGenerations);
        final Color cpy = Config.palette.getPrimaryColor().cpy();
        cpy.a = Settings.transparency;
        sr.setColor(cpy);
    }

    @Override
    protected void drawFrame() {
        if (index < out.length()) {
            char c = out.charAt(index);
            switch (c) {
                case 'A', 'B', 'F', 'G' -> move(Settings.distance);
                case '+' -> rotate(Settings.rotateLeft);
                case '-' -> rotate(Settings.rotateRight);
                case '[' -> pushState();
                case ']' -> popState();
            }
            index++;
        }
    }
}
