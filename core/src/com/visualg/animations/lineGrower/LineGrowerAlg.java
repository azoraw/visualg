package com.visualg.animations.lineGrower;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.ui.pixmap.PixmapAlg;
import com.visualg.ui.pixmap.PixmapFactory;
import com.visualg.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;

class LineGrowerAlg extends PixmapAlg {
    private static final int NUMBER_OF_INIT_POINTS = 3;
    int NUMBER_OF_NEW_SEGMENTS = 2;
    private static final int[] DIR = getInts();

    private static int[] getInts() {
        int shift = 5;
        int[] ints = new int[shift * 2 + 2];
        int index = 0;
        for (int i = -shift; i < shift; i++) {
            ints[index] = i;
            index++;
        }
        return ints;
    }

    private static final int MAX_NUMBER_OF_GROWING_SEGMENTS = 100;
    private static final int MAX_NUMBER_OF_All_SEGMENTS = 1_0000;
    private Pixmap pixmap;

    private final HashSet<Segment> growingSegments = new HashSet<>();
    private final ArrayList<Segment> allSegments = new ArrayList<>();
    private Segment[][] pixels = new Segment[WIDTH + 1][HEIGHT + 1];

    LineGrowerAlg() {
        pixmap = PixmapFactory.create();
        createInitPoints();
    }

    private void createInitPoints() {
        for (int i = 0; i < NUMBER_OF_INIT_POINTS; i++) {
            addNewSegment(new Segment());
        }

        grow();
    }

    private void grow() {
        HashSet<Segment> segmentsToRemove = new HashSet<>();
        updateGrowingSegments(segmentsToRemove);
        stopGrow(segmentsToRemove);
        createNewSegments(segmentsToRemove);
    }

    private void stopGrow(HashSet<Segment> segmentsToRemove) {
        growingSegments.removeAll(segmentsToRemove);
    }

    private void createNewSegments(HashSet<Segment> segmentsToRemove) {
        if (MAX_NUMBER_OF_GROWING_SEGMENTS < growingSegments.size()) {
            return;
        }
        if (MAX_NUMBER_OF_All_SEGMENTS < allSegments.size()) {
            return;
        }
        for (int i = 0; i < segmentsToRemove.size() * NUMBER_OF_NEW_SEGMENTS; i++) {
            Segment perpendicular = allSegments.get(RandomGenerator.Random.nextInt(allSegments.size()))
                    .createPerpendicular();
            for (int numbreOfTries = 0; numbreOfTries < 100; numbreOfTries++) {
                if (canAddNewSegment(perpendicular)) {
                    break;
                }
                perpendicular = allSegments.get(RandomGenerator.Random.nextInt(allSegments.size()))
                        .createPerpendicular();
            }
            addNewSegment(perpendicular);
        }
    }

    private boolean canAddNewSegment(Segment newSegment) {
        int x;
        int y;
        for (int xShift : DIR) {
            for (int yShift : DIR) {
                x = (int) newSegment.getInitPosition().x + xShift;
                y = (int) newSegment.getInitPosition().y + yShift;
                if (!isInbound(x, y)) {
                    continue;
                }
                if (pixels[x][y] != null) {
                    if ((int) pixels[x][y].getInitPosition().x == (int) newSegment.getInitPosition().x) {
                        return false;
                    }
                    if ((int) pixels[x][y].getInitPosition().y == (int) newSegment.getInitPosition().y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private boolean isInbound(int x, int y) {
        return x > 1 && y > 1 && x < WIDTH-1 && y < HEIGHT-1;
    }

    private void addNewSegment(Segment segment) {
        growingSegments.add(segment);
        allSegments.add(segment);
        drawPixel(segment);
    }

    private void updateGrowingSegments(HashSet<Segment> segmentsToRemove) {
        for (Segment segment : growingSegments) {
            boolean growing = segment.grow(pixels);
            if (growing) {
                drawPixel(segment);
            } else {
                segmentsToRemove.add(segment);
            }
        }
    }

    private void drawPixel(Segment segment) {
        int x = (int) segment.getPosition().x;
        int y = (int) segment.getPosition().y;
        pixels[x][y] = segment;
        pixmap.drawPixel(x, y,  Color.rgba8888(palette.getPrimaryColor()));
    }

    @Override
    public Pixmap getPixMap() {
        return pixmap;
    }

    void update() {
        grow();
    }
}
