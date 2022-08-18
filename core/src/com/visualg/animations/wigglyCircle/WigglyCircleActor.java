package com.visualg.animations.wigglyCircle;

import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Pair;

import java.util.List;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

class WigglyCircleActor extends ShapeRendererActor {

    private final WigglyCircleAlg alg;
    float[] points;

    WigglyCircleActor(WigglyCircleAlg alg) {
        super(Line);
        this.alg = alg;
    }

    @Override
    protected void drawFrame() {
        List<Pair<Float, Float>> pairs = alg.getVertices();

        points = new float[2 * pairs.size()];
        for (int i = 0; i < pairs.size(); i++) {
            points[2 * i] = pairs.get(i).first();
            points[2 * i + 1] = pairs.get(i).second();
        }
        sr.polygon(points);
        alg.update();
    }
}
