package com.visualg.animations.waveFuncCollapse.texture;

import com.visualg.animations.waveFuncCollapse.Settings;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static com.visualg.util.RandomDecorator.Random;

class TextureRules {

    @Getter
    private final List<TextureRule> rules = new ArrayList<>();
    @Getter
    private int cellSize;

    TextureRules() {
        switch (Settings.INSTANCE.variant) {
            case VARIANT1 -> init1();
            case VARIANT2 -> init2();
            case PSEUDO_RANDOM -> initPseudoRandom();
            default -> throw new UnsupportedOperationException();
        }
    }

    private void init1() {
        cellSize = 3;
        add(1, (x, y) -> false);
        add(2, (x, y) -> y == 1 || (x == 1 && y == 0));
        add(3, (x, y) -> x == 1 || (x == 2 && y == 1));
        add(4, (x, y) -> y == 1 || (x == 1 && y == 2));
        add(5, (x, y) -> x == 1 || (x == 0 && y == 1));
    }

    private void init2() {
        cellSize = 3;
        add(1, (x, y) -> true);
        add(2, (x, y) -> y == 1 || (x == 1 && y == 0));
        add(3, (x, y) -> x == 1 || (x == 2 && y == 1));
        add(4, (x, y) -> y == 1 || (x == 1 && y == 2));
        add(5, (x, y) -> x == 1 || (x == 0 && y == 1));
    }

    private void initPseudoRandom() {
        cellSize = 4;
        add(1, (x, y) -> false);
        add(2, (x, y) -> y == Random.nextInt(cellSize) && x == Random.nextInt(cellSize));
        add(3, (x, y) -> y == Random.nextInt(cellSize) && x == Random.nextInt(cellSize));
        add(4, (x, y) -> y == Random.nextInt(cellSize) && x == Random.nextInt(cellSize));
        add(5, (x, y) -> y == Random.nextInt(cellSize) || x == Random.nextInt(cellSize));
    }

    private void add(int indexElement, BiFunction<Integer, Integer, Boolean> activeCellsFunction) {
        rules.add(new TextureRule(indexElement, activeCellsFunction));
    }
}
