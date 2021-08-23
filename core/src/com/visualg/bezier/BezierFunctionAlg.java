package com.visualg.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class BezierFunctionAlg {

    public static Set<Pair<Vector2, Vector2>> getQuadraticBezier(Vector2 start, Vector2 middle, Vector2 end, int delta) {
        HashSet<Pair<Vector2, Vector2>> lines = new HashSet<>();

        for (int i = 0; i <= delta; i++) {
            Vector2 lerp1 = start.cpy().lerp(middle, (float) i / delta);
            Vector2 lerp2 = middle.cpy().lerp(end, (float) i / delta);
            lines.add(new Pair<>(lerp1, lerp2));
        }
        return lines;
    }
}
