package com.visualg.lines;

import com.badlogic.gdx.Gdx;
import com.visualg.util.Pair;
import com.visualg.util.RandomGenerator;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

class Lines {

    private final int width;
    private final int height;
    private List<LineSegment> segments = new ArrayList<>();

    public Lines() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        Pair<Integer, Integer> tmp = getNewPoint();
        Pair<Integer, Integer> tmp2 = getNewPoint();
        segments.add(new LineSegment(tmp.first, tmp.second, tmp2.first, tmp2.second));
    }


    void update() {
        Pair<Integer, Integer> newPoint1 = getNewPoint();
        Pair<Integer, Integer> newPoint2 = getNewPoint();
        LineSegment lineSegment = new LineSegment(newPoint1.first, newPoint1.second, newPoint2.first, newPoint2.second);

        if (canAdd(lineSegment)) {
            segments.add(lineSegment);
        }
    }

    private boolean canAdd(LineSegment lineSegment) {
        return segments.stream()
                .noneMatch(e -> Line2D.linesIntersect(e.x1, e.y1, e.x2, e.y2, lineSegment.x1, lineSegment.y1, lineSegment.x2, lineSegment.y2));
    }

    List<LineSegment> getSegments() {
        return segments;
    }

    private Pair<Integer, Integer> getNewPoint() {

        return new Pair<>(RandomGenerator.getIntInRange(width), RandomGenerator.getIntInRange(height));
    }


}
