package com.visualg.animations.bezier;

import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;

import java.util.HashSet;
import java.util.Set;

class BezierFunctionAlg {

    public static Set<Pair<Vector2, Vector2>> getQuadraticBezier(Vector2 start, Vector2 middle, Vector2 end, int delta) {
        HashSet<Pair<Vector2, Vector2>> lines = new HashSet<>();

        for (int i = 0; i <= delta; i++) {
            Vector2 lerp1 = start.cpy().lerp(middle, (float) i / delta);
            Vector2 lerp2 = middle.cpy().lerp(end, (float) i / delta);
            lines.add(new Pair<>(lerp1, lerp2));
        }
        return lines;
    }

    public static Set<Pair<Vector2, Vector2>> getQuadraticBezier(Vector2 position0, Vector2 position1, Vector2 position2, Vector2 position3, int delta) {
        HashSet<Pair<Vector2, Vector2>> lines = new HashSet<>();

        for (int i = 0; i <= delta; i++) {
            Vector2 lerp1 = position0.cpy().lerp(position1, (float) i / delta);
            Vector2 lerp2 = position1.cpy().lerp(position2, (float) i / delta);
            Vector2 lerp3 = position2.cpy().lerp(position3, (float) i / delta);
            Vector2 lerp4 = position3.cpy().lerp(position0, (float) i / delta);

            lines.add(new Pair<>(lerp1, lerp2));
            lines.add(new Pair<>(lerp2, lerp3));
            lines.add(new Pair<>(lerp3, lerp4));
            lines.add(new Pair<>(lerp4, lerp1));

        }
        return lines;
    }
}
