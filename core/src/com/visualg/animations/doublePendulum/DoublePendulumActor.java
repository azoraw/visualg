package com.visualg.animations.doublePendulum;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererActor;

import static com.visualg.global.Config.palette;

public class DoublePendulumActor extends ShapeRendererActor {

    State state;

    public DoublePendulumActor() {
        super(ShapeRenderer.ShapeType.Line);
        state = new State();
    }

    @Override
    protected void drawFrame() {

        sr.setColor(palette.getPrimaryColor());
        sr.line((float) state.getX0(), (float) state.getY0(), (float) state.getX1(), (float) state.getY1());
        sr.line((float) state.getX1(), (float) state.getY1(), (float) state.getX2(), (float) state.getY2());
        sr.end();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Config.palette.getPrimaryColor());
        sr.circle((float) state.getX1(), (float) state.getY1(), state.getM1());
        sr.setColor(Config.palette.getSecondaryColor());
        sr.circle((float) state.getX2(), (float) state.getY2(), state.getM2());
        state.updateState();
    }
}
