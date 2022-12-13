package com.visualg.util.qTree;

import java.util.ArrayList;

public class QTree {
    private final Rectangle boundary;
    private final ArrayList<Point> points = new ArrayList<>();
    private final int capacity;

    private boolean isDivided = false;
    private QTree northEast, northWest, southEast, southWest;

    public QTree(Rectangle boundary, int capacity) {
        this.boundary = new Rectangle(boundary);
        this.capacity = capacity;
    }

    public boolean insert(Point point) {
        if (!boundary.contains(point)) {
            return false;
        }
        if (points.size() < capacity) {
            points.add(point);
            return true;
        }
        subdivide();
        if (northEast.insert(point)) {
            return true;
        } else if (northWest.insert(point)) {
            return true;
        } else if (southEast.insert(point)) {
            return true;
        } else if (southWest.insert(point)) {
            return true;
        }

        return false;
    }

    private void subdivide() {
        if (isDivided) {
            return;
        }
        float x = boundary.x;
        float y = boundary.y;
        float w = boundary.w * 0.5f;
        float h = boundary.h * 0.5f;

        Rectangle ne = new Rectangle(x + w, y - h, w, h);
        northEast = new QTree(ne, capacity);
        Rectangle nw = new Rectangle(x - w, y - h, w, h);
        northWest = new QTree(nw, capacity);
        Rectangle se = new Rectangle(x + w, y + h, w, h);
        southEast = new QTree(se, capacity);
        Rectangle sw = new Rectangle(x - w, y + h, w, h);
        southWest = new QTree(sw, capacity);
        isDivided = true;
    }

    public ArrayList<Point> query(Rectangle range, ArrayList<Point> found) {
        if (boundary.intersects(range)) {
            for (Point p : points) {
                if (range.contains(p)) {
                    found.add(p);
                }
            }
            if (isDivided) {
                northWest.query(range, found);
                northEast.query(range, found);
                southWest.query(range, found);
                southEast.query(range, found);
            }
        }
        return found;
    }
}
