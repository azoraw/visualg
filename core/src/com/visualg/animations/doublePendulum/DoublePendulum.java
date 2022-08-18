package com.visualg.animations.doublePendulum;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.ui.ShapeRendererActor;

public class DoublePendulum extends ShapeRendererActor {

    State state;

    public DoublePendulum() {
        super(ShapeRenderer.ShapeType.Line);
        state = new State();
    }

    @Override
    protected void drawFrame() {

        sr.setColor(Color.WHITE);
        sr.line((float) state.getX0(), (float) state.getY0(), (float) state.getX1(), (float) state.getY1());
        sr.line((float) state.getX1(), (float) state.getY1(), (float) state.getX2(), (float) state.getY2());
        sr.end();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.BLUE);
        sr.circle((float) state.getX1(), (float) state.getY1(), state.getM1());
        sr.setColor(Color.GREEN);
        sr.circle((float) state.getX2(), (float) state.getY2(), state.getM2());
        state.updateState();
    }
}
