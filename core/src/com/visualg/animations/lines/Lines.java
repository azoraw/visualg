package com.visualg.animations.lines;

import com.visualg.util.Pair;
import com.visualg.util.RandomGenerator;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class Lines {

    private final List<LineSegment> segments = new ArrayList<>();

    Lines() {
        Pair<Integer, Integer> tmp = getNewRandomPoint();
        Pair<Integer, Integer> tmp2 = getNewRandomPoint();
        segments.add(new LineSegment(tmp.first(), tmp.second(), tmp2.first(), tmp2.second()));
    }


    void update() {
        Pair<Integer, Integer> newPoint = getNewRandomPoint();

        LineSegment newSegment = new LineSegment(segments.get(segments.size() - 1).x2, segments.get(segments.size() - 1).y2, newPoint.first(), newPoint.second());

        if (canAdd(newSegment)) {
            segments.add(newSegment);
        }
    }

    private boolean canAdd(LineSegment newSegment) {
        for (int i = 0; i < segments.size() - 1; i++) {
            if (Line2D.linesIntersect(segments.get(i).x1, segments.get(i).y1, segments.get(i).x2, segments.get(i).y2,
                    newSegment.x1, newSegment.y1, newSegment.x2, newSegment.y2)) {
                return false;
            }
        }
        return true;
    }

    List<LineSegment> getSegments() {
        return segments;
    }

    private Pair<Integer, Integer> getNewRandomPoint() {
        return new Pair<>(RandomGenerator.Random.nextInt(WIDTH), RandomGenerator.Random.nextInt(HEIGHT));
    }


}
