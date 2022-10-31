package com.visualg.animations.waveFuncCollapse.rules.tiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visualg.util.Direction.DOWN;
import static com.visualg.util.Direction.LEFT;
import static com.visualg.util.Direction.RIGHT;
import static com.visualg.util.Direction.UP;
import static java.util.List.of;

public class Tileset1Rules implements TilesetRules {
    private final Map<Integer, List<TilesetRule>> tilesetRules = new HashMap<>();

    public Tileset1Rules() {
        addTile(1, 1, 0, 1, 0);
        addTile(2, 0, 1, 0, 1);
        addTile(3, 2, 0, 2, 0);
        addTile(4, 0, 2, 0, 2);
        addTile(5, 1, 2, 1, 2);
        addTile(6, 2, 1, 2, 1);
        addTile(7, 1, 2, 1, 2);
        addTile(8, 2, 1, 2, 1);
        addTile(9, 2, 2, 0, 0);
        addTile(10, 0, 2, 2, 0);
        addTile(11, 0, 0, 2, 2);
        addTile(12, 2, 0, 0, 2);
        addTile(13, 1, 1, 0, 0);
        addTile(14, 0, 1, 1, 0);
        addTile(15, 0, 0, 1, 1);
        addTile(16, 1, 0, 0, 1);
        addTile(17, 1, 1, 1, 1);
        addTile(18, 2, 2, 2, 2);
    }

    private void addTile(int key, int up, int right, int down, int left) {
        tilesetRules.put(key, of(new TilesetRule(UP, "" + up),
                new TilesetRule(RIGHT, "" + right),
                new TilesetRule(DOWN, "" + down),
                new TilesetRule(LEFT, "" + left)));
    }

    @Override
    public List<TilesetRule> get(int index) {
        return tilesetRules.get(index);
    }

    @Override
    public int getTilesetCount() {
        return 18;
    }
}
