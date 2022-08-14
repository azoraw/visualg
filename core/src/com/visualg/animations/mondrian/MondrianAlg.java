package com.visualg.animations.mondrian;

import com.visualg.global.Config;
import com.visualg.util.RandomGenerator;
import com.visualg.util.color.Palette;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.animations.mondrian.Settings.INSTANCE;

class MondrianAlg {

    private static final int MAX_SIZE = 10_000;
    private final Palette palette;
    private final float[] splits = {0.5f, 1, 1.5f};

    @Getter
    private final List<Rect> rectangles = new ArrayList<>();

    public MondrianAlg() {
        int width;
        int height;
        if (INSTANCE.getSpace() == 0) {
            width = (int) Math.pow(2, 11);
            height = (int) Math.pow(2, 11);
        } else {
            width = Config.WIDTH;
            height = Config.HEIGHT;
        }
        if (INSTANCE.isMondriatsPalette()) {
            palette = new Palette(Palette.MONDRIANS_PALETTE);
        } else {
            palette = new Palette(INSTANCE.getPaletteSize());
        }
        Rect rect = Rect.builder()
                .x(2 * INSTANCE.getSpace())
                .y(2 * INSTANCE.getSpace())
                .width((width) - 4 * INSTANCE.getSpace())
                .height(height - 4 * INSTANCE.getSpace())
                .color(palette.getRandomColor())
                .build();
        rectangles.add(rect);
    }

    void update() {
        int index = RandomGenerator.getIntInRange(rectangles.size());
        Rect split = rectangles.get(index);
        if (split.getHeight() < INSTANCE.getSideMaxSplitLength() || split.getWidth() < INSTANCE.getSideMaxSplitLength()
                || rectangles.size() > MAX_SIZE) {
            return;
        }
        Rect rect1;
        Rect rect2;
        float currentSplit = getCurrentSplit();
        if (RandomGenerator.nextBoolean()) {
            rect1 = Rect.builder()
                    .x(split.getX())
                    .y(split.getY())
                    .width((int) ((split.getWidth() / 2) * currentSplit) - INSTANCE.getSpace())
                    .height(split.getHeight())
                    .color(palette.getRandomColor())
                    .build();
            rect2 = Rect.builder()
                    .x(split.getX() + (int) ((split.getWidth() / 2) * currentSplit) + INSTANCE.getSpace())
                    .y(split.getY())
                    .width((int) ((split.getWidth() / 2) * (2 - currentSplit)) - INSTANCE.getSpace())
                    .height(split.getHeight())
                    .color(palette.getRandomColor())
                    .build();
        } else {
            rect1 = Rect.builder()
                    .x(split.getX())
                    .y(split.getY())
                    .width(split.getWidth())
                    .height((int) ((split.getHeight() / 2) * currentSplit) - INSTANCE.getSpace())
                    .color(palette.getRandomColor())
                    .build();
            rect2 = Rect.builder()
                    .x(split.getX())
                    .y((int) (split.getY() + (split.getHeight() / 2) * currentSplit) + INSTANCE.getSpace())
                    .width(split.getWidth())
                    .height((int) ((split.getHeight() / 2) * (2 - currentSplit)) - INSTANCE.getSpace())
                    .color(palette.getRandomColor())
                    .build();
        }
        rectangles.set(index, rect1);
        rectangles.add(rect2);
    }

    private float getCurrentSplit() {
        float currentSplit = 1f;
        if(INSTANCE.getSpace() != 0) {
            currentSplit = splits[RandomGenerator.nextInt(splits.length)];
        }
        return currentSplit;
    }
}
