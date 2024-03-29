package com.visualg.animations.mondrian;

import com.visualg.global.Config;
import com.visualg.util.color.Palette;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.animations.mondrian.MondrianSettings.RESOLUTION;
import static com.visualg.animations.mondrian.MondrianSettings.settings;
import static com.visualg.util.RandomDecorator.Random;

class MondrianAlg {

    private static final int MAX_SIZE = 10_0000;
    private final Palette palette;
    private final float[] splits = {0.5f, 1, 1.5f};

    @Getter
    private final List<Rect> rectangles = new ArrayList<>();

    MondrianAlg() {
        int width;
        int height;
        if (settings.getSpace() == 0) {
            width = RESOLUTION;
            height = RESOLUTION;
        } else {
            width = Config.WIDTH;
            height = Config.HEIGHT;
        }
        if (settings.isMondriatsPalette()) {
            palette = new Palette(Palette.MONDRIANS_PALETTE);
        } else {
            palette = new Palette(settings.getPaletteSize());
        }
        Rect rect = Rect.builder()
                .x(2 * settings.getSpace())
                .y(2 * settings.getSpace())
                .width((width) - 4 * settings.getSpace())
                .height(height - 4 * settings.getSpace())
                .color(palette.getRandomColor())
                .build();
        rectangles.add(rect);
    }

    void update() {
        int index = Random.nextInt(rectangles.size());
        Rect split = rectangles.get(index);
        if (split.height() < settings.getSideMaxSplitLength() || split.width() < settings.getSideMaxSplitLength()
                || rectangles.size() > MAX_SIZE) {
            return;
        }
        Rect rect1;
        Rect rect2;
        float currentSplit = getCurrentSplit();
        if (Random.nextBoolean()) {
            rect1 = Rect.builder()
                    .x(split.x())
                    .y(split.y())
                    .width((int) ((split.width() / 2) * currentSplit) - settings.getSpace())
                    .height(split.height())
                    .color(palette.getRandomColor())
                    .build();
            rect2 = Rect.builder()
                    .x(split.x() + (int) ((split.width() / 2) * currentSplit) + settings.getSpace())
                    .y(split.y())
                    .width((int) ((split.width() / 2) * (2 - currentSplit)) - settings.getSpace())
                    .height(split.height())
                    .color(palette.getRandomColor())
                    .build();
        } else {
            rect1 = Rect.builder()
                    .x(split.x())
                    .y(split.y())
                    .width(split.width())
                    .height((int) ((split.height() / 2) * currentSplit) - settings.getSpace())
                    .color(palette.getRandomColor())
                    .build();
            rect2 = Rect.builder()
                    .x(split.x())
                    .y((int) (split.y() + (split.height() / 2) * currentSplit) + settings.getSpace())
                    .width(split.width())
                    .height((int) ((split.height() / 2) * (2 - currentSplit)) - settings.getSpace())
                    .color(palette.getRandomColor())
                    .build();
        }
        rectangles.set(index, rect1);
        rectangles.add(rect2);
    }

    private float getCurrentSplit() {
        float currentSplit = 1f;
        if (settings.getSpace() != 0) {
            currentSplit = splits[Random.nextInt(splits.length)];
        }
        return currentSplit;
    }
}
