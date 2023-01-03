package com.visualg.animations.rectangles;


import java.util.HashSet;
import java.util.Set;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class Squares {

    private static final float DIFF_STEP = 0.001f;
    private float diffMultiplier = 1;

    final int width;
    final int height;


    Squares() {
        this.width = WIDTH;
        this.height = HEIGHT - 1;
    }

    Set<Line> getLinesForNumberOfSquares(int numberOfSquares) {
        Line line1 = new Line(1, 1, 1, height, diffMultiplier);
        Line line2 = new Line(1, height, width, height, diffMultiplier);
        Line line3 = new Line(width, height, width, 0, diffMultiplier);
        Line line4 = new Line(width, 1, 1, 1, diffMultiplier);

        HashSet<Line> lines = new HashSet<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);

        for (int i = 0; i < numberOfSquares; i++) {

            Line line1tmp = new Line(line1.getNextX(), line1.getNextY(), line2.getNextX(), line2.getNextY(), diffMultiplier);
            Line line2tmp = new Line(line2.getNextX(), line2.getNextY(), line3.getNextX(), line3.getNextY(), diffMultiplier);
            Line line3tmp = new Line(line3.getNextX(), line3.getNextY(), line4.getNextX(), line4.getNextY(), diffMultiplier);
            Line line4tmp = new Line(line4.getNextX(), line4.getNextY(), line1.getNextX(), line1.getNextY(), diffMultiplier);
            line1 = line1tmp;
            line2 = line2tmp;
            line3 = line3tmp;
            line4 = line4tmp;
            lines.add(line1);
            lines.add(line2);
            lines.add(line3);
            lines.add(line4);
        }

        return lines;
    }

    void updateAnimationLoop() {
        diffMultiplier -= DIFF_STEP;
        if (diffMultiplier < -1) {
            diffMultiplier = 1;
        }
    }
}
