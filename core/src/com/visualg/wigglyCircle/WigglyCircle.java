package com.visualg.wigglyCircle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.util.Pair;

import java.util.List;

public class WigglyCircle extends Actor {

    private final ShapeRenderer sr;
    private final WigglyCircleAlg alg;
    float[] points;
    int width;
    int height;

    public WigglyCircle() {
        sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        alg = new WigglyCircleAlg((float) width / 2, (float) height / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        List<Pair<Float, Float>> pairs = alg.getVertices();

        points = new float[2 * pairs.size()];
        for (int i = 0; i < pairs.size(); i++) {
            points[2 * i] = pairs.get(i).first;
            points[2 * i + 1] = pairs.get(i).second;
        }
        sr.polygon(points);
        sr.end();
        alg.update();
        batch.begin();
    }
}
