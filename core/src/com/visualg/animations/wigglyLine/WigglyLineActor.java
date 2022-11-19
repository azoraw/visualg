package com.visualg.animations.wigglyLine;

import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Pair;

import java.util.List;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

class WigglyLineActor extends ShapeRendererActor {

    private final WigglyLineAlg alg;
    float[] points;

    WigglyLineActor(WigglyLineAlg alg) {
        super(Line);
        this.alg = alg;
    }

    @Override
    protected void drawFrame() {
        final List<Pair<Integer, Integer>> pairs = alg.getVertices();

        points = new float[2 * pairs.size()];
        for (int i = 0; i < pairs.size(); i++) {
            points[2 * i] = pairs.get(i).first();
            points[2 * i + 1] = pairs.get(i).second();
        }
        sr.polyline(points);
        alg.update();
    }
}
