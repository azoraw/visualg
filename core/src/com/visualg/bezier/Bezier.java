package com.visualg.bezier;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.util.Pair;

public class Bezier extends Actor {

    private final ShapeRenderer sr;
    private final OldWidowsScreenSaver oldWidowsScreenSaver;

    public Bezier() {
        oldWidowsScreenSaver = new OldWidowsScreenSaver(Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        for (Pair<Vector2, Vector2> line : oldWidowsScreenSaver.getLines()) {
            sr.line(line.first, line.second);
        }
        sr.end();
        oldWidowsScreenSaver.update();
    }

}
