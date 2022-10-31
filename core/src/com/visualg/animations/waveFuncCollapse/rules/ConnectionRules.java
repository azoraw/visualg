package com.visualg.animations.waveFuncCollapse.rules;

import com.visualg.animations.waveFuncCollapse.Settings;
import com.visualg.animations.waveFuncCollapse.rules.tiles.CarrcasRules;
import com.visualg.animations.waveFuncCollapse.rules.tiles.Tileset1Rules;
import com.visualg.animations.waveFuncCollapse.rules.tiles.TilesetRule;
import com.visualg.animations.waveFuncCollapse.rules.tiles.TilesetRules;
import com.visualg.util.Direction;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.visualg.util.Direction.DOWN;
import static com.visualg.util.Direction.LEFT;
import static com.visualg.util.Direction.RIGHT;
import static com.visualg.util.Direction.UP;
import static com.visualg.util.Direction.values;

class ConnectionRules {
    @Getter
    private final List<ConnectionRule> rules = new ArrayList<>();

    public ConnectionRules() {
        switch (Settings.INSTANCE.variant) {
            case VARIANT1, VARIANT2 -> init1();
            case PSEUDO_RANDOM -> initPseudorandom();
            case TILES1 -> initTiles1(new Tileset1Rules());
            case TILES2 -> initTiles2(new Tileset1Rules());
            case TILES3 -> initTiles3(new Tileset1Rules());
            case TILES4 -> initTiles4(new Tileset1Rules());
            case TILES5 -> initTiles5(new Tileset1Rules());
            case CARRCAS -> initCarrcas();
            default -> throw new UnsupportedOperationException();
        }
    }

    private void initCarrcas() {
        CarrcasRules carrcasRules = new CarrcasRules();
        List<Integer> tiles = IntStream.rangeClosed(1, carrcasRules.getTilesetCount()).boxed().collect(Collectors.toList());
        tiles.remove(3);
        addTiles(tiles, carrcasRules);
    }

    private void initTiles4(Tileset1Rules tileset1Rules) {
        List<Integer> tiles = List.of(1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
        addTiles(tiles, tileset1Rules);
    }

    private void initTiles3(Tileset1Rules tileset1Rules) {
        List<Integer> tiles = List.of(3, 4, 9, 10, 11, 12);
        addTiles(tiles, tileset1Rules);
    }

    private void initTiles2(Tileset1Rules tileset1Rules) {
        List<Integer> tiles = IntStream.rangeClosed(1, 16).boxed().collect(Collectors.toList());
        addTiles(tiles, tileset1Rules);
    }

    private void initTiles5(Tileset1Rules tileset1Rules) {
        List<Integer> tiles = List.of(1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 14, 15, 16);
        addTiles(tiles, tileset1Rules);
    }

    private void initTiles1(Tileset1Rules tileset1Rules) {
        List<Integer> tiles = IntStream.rangeClosed(1, 18).boxed().collect(Collectors.toList());
        addTiles(tiles, tileset1Rules);
    }

    private void addTiles(List<Integer> tiles, TilesetRules tilesetRules) {
        for (int tile : tiles) {
            List<TilesetRule> tileRules = tilesetRules.get(tile);
            for (TilesetRule tilesetRule : tileRules) {
                add(tile, tilesetRule.direction(), tilesetRule.connector());
            }
        }
    }


    private void initPseudorandom() {
        for (int i = 1; i <= 5; i++) {
            for (Direction dir : values()) {
                add(i, dir, "" + RandomGenerator.getIntInRange(4));
            }
        }
    }

    private void init1() {
        add(1, UP, "AAA");
        add(1, RIGHT, "AAA");
        add(1, DOWN, "AAA");
        add(1, LEFT, "AAA");
        add(2, UP, "ABA");
        add(2, RIGHT, "ABA");
        add(2, DOWN, "AAA");
        add(2, LEFT, "ABA");
        add(3, UP, "ABA");
        add(3, RIGHT, "ABA");
        add(3, DOWN, "ABA");
        add(3, LEFT, "AAA");
        add(4, UP, "AAA");
        add(4, RIGHT, "ABA");
        add(4, DOWN, "ABA");
        add(4, LEFT, "ABA");
        add(5, UP, "ABA");
        add(5, RIGHT, "AAA");
        add(5, DOWN, "ABA");
        add(5, LEFT, "ABA");
    }

    private void add(int index, Direction direction, String connector) {
        rules.add(new ConnectionRule(index, direction, connector));
    }
}
