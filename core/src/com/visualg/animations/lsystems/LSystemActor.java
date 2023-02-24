package com.visualg.animations.lsystems;


import com.badlogic.gdx.graphics.Color;
import com.visualg.global.Config;
import com.visualg.ui.TurtleGraphicRenderer;

import static com.visualg.animations.lsystems.Settings.Settings;

class LSystemActor extends TurtleGraphicRenderer {

    private final String out;
    private int index = 0;

    LSystemActor() {
        super(Settings.xStart, Settings.yStart);
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
            if (c == 'F') {
                move(Settings.distance);
            } else if (c == '+') {
                rotate(Settings.rotateLeft);
            } else if (c == '-') {
                rotate(Settings.rotateRight);
            }
            index++;
        }
    }
}
