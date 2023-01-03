package com.visualg.animations.rectangles;

import com.visualg.ui.FrameBufferActor;

import java.util.Set;

public class RectanglesTransparentActor extends FrameBufferActor {

    private final Squares squares;

    public RectanglesTransparentActor() {
        super(true);
        squares = new Squares();
    }


    @Override
    protected void drawFrame() {
        Set<Line> lines = squares.getLinesForNumberOfSquares(50);
        for (Line line : lines) {
            sr.line(line.x1, line.y1, line.x2, line.y2);
        }
        squares.updateAnimationLoop();
    }

}
