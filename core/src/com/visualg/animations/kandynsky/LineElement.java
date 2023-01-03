package com.visualg.animations.kandynsky;

import com.visualg.util.Pair;
import lombok.Data;

import java.awt.geom.Line2D;
import java.io.Serial;

@Data
public class LineElement implements Element {
    @Serial
    private static final long serialVersionUID = 1L;

    private float xStart;
    private float yStart;
    private float xEnd;
    private float yEnd;

    public LineElement(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public Pair<Float, Float> getCenter() {
        float x = Math.min(xStart, xEnd) + Math.abs((xStart - xEnd) / 2);
        float y = Math.min(yStart, yEnd) + Math.abs((yStart - yEnd) / 2);
        return new Pair<>(x, y);
    }

    @Override
    public void move(int x, int y) {
        final Pair<Float, Float> center = getCenter();
        float xDelta = x - center.first();
        float yDelta = y - center.second();
        xStart += xDelta;
        yStart += yDelta;
        xEnd += xDelta;
        yEnd += yDelta;
    }

    @Override
    public double distance(int x, int y) {
        return Line2D.ptSegDist(xStart, yStart, xEnd, yEnd, x, y);
    }

    @Override
    public void rotate(int angle) {
        
        final Pair<Float, Float> center = getCenter();
        final Float centerX = center.first();
        final Float centerY = center.second();

        double x1 = xStart - centerX;
        double y1 = yStart - centerY;

        double x2 = x1 * Math.cos(Math.toRadians(angle)) - y1 * Math.sin(Math.toRadians(angle));
        double y2 = x1 * Math.sin(Math.toRadians(angle)) + y1 * Math.cos(Math.toRadians(angle));

        xStart = (float) (x2 + centerX);
        yStart = (float) (y2 + centerY);

        x1 = xEnd - centerX;
        y1 = yEnd - centerY;

        x2 = x1 * Math.cos(Math.toRadians(angle)) - y1 * Math.sin(Math.toRadians(angle));
        y2 = x1 * Math.sin(Math.toRadians(angle)) + y1 * Math.cos(Math.toRadians(angle));

        xEnd = (float) (x2 + centerX);
        yEnd = (float) (y2 + centerY);
    }
}
