package com.visualg.animations.waveFuncCollapse.rules.tiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visualg.util.Direction.DOWN;
import static com.visualg.util.Direction.LEFT;
import static com.visualg.util.Direction.RIGHT;
import static com.visualg.util.Direction.UP;
import static java.util.List.of;

public class CarrcasRules implements TilesetRules {
    private final Map<Integer, List<TilesetRule>> tilesetRules = new HashMap<>();
    private static final String GRASS = "G";
    private static final String ROAD = "R";
    private static final String CITY = "C";

    public CarrcasRules() {
        addTile(1, GRASS, GRASS, GRASS, GRASS);
        addTile(2, CITY, CITY, CITY, CITY);
        addTile(3, ROAD, ROAD, ROAD, ROAD);
        addTile(4, CITY, ROAD, GRASS, ROAD);

        addTile(5, GRASS, GRASS, ROAD, GRASS);
        addTile(6, GRASS, GRASS, GRASS, ROAD);
        addTile(7, ROAD, GRASS, GRASS, GRASS);
        addTile(8, GRASS, ROAD, GRASS, GRASS);

        addTile(9, CITY, CITY, GRASS, CITY);
        addTile(10, CITY, CITY, CITY, GRASS);
        addTile(11, GRASS, CITY, CITY, CITY);
        addTile(12, CITY, GRASS, CITY, CITY);

        addTile(13, CITY, CITY, GRASS, CITY);
        addTile(14, CITY, CITY, CITY, GRASS);
        addTile(15, GRASS, CITY, CITY, CITY);
        addTile(16, CITY, GRASS, CITY, CITY);

        addTile(17, CITY, CITY, ROAD, CITY);
        addTile(18, CITY, CITY, CITY, ROAD);
        addTile(19, ROAD, CITY, CITY, CITY);
        addTile(20, CITY, ROAD, CITY, CITY);

        addTile(21, CITY, CITY, ROAD, CITY);
        addTile(22, CITY, CITY, CITY, ROAD);
        addTile(23, ROAD, CITY, CITY, CITY);
        addTile(24, CITY, ROAD, CITY, CITY);

        addTile(25, CITY, GRASS, GRASS, CITY);
        addTile(26, CITY, CITY, GRASS, GRASS);
        addTile(27, GRASS, CITY, CITY, GRASS);
        addTile(28, GRASS, GRASS, CITY, CITY);

        addTile(29, CITY, GRASS, GRASS, CITY); //with shield
        addTile(30, CITY, CITY, GRASS, GRASS);
        addTile(31, GRASS, CITY, CITY, GRASS);
        addTile(32, GRASS, GRASS, CITY, CITY);

        addTile(33, CITY, ROAD, ROAD, CITY);//2 roads
        addTile(34, CITY, CITY, ROAD, ROAD);
        addTile(35, ROAD, CITY, CITY, ROAD);
        addTile(36, ROAD, ROAD, CITY, CITY);

        addTile(37, CITY, ROAD, ROAD, CITY); //2 roads + shield
        addTile(38, CITY, CITY, ROAD, ROAD);
        addTile(39, ROAD, CITY, CITY, ROAD);
        addTile(40, ROAD, ROAD, CITY, CITY);

        addTile(41, GRASS, CITY, GRASS, CITY);
        addTile(42, CITY, GRASS, CITY, GRASS);
        addTile(43, GRASS, CITY, GRASS, CITY);
        addTile(44, CITY, GRASS, CITY, GRASS);

        addTile(45, CITY, GRASS, GRASS, CITY);
        addTile(46, CITY, CITY, GRASS, GRASS);
        addTile(47, GRASS, GRASS, CITY, CITY);
        addTile(48, GRASS, CITY, CITY, GRASS);

        addTile(49, CITY, GRASS, CITY, GRASS);
        addTile(50, GRASS, CITY, GRASS, CITY);
        addTile(51, ROAD, GRASS, ROAD, GRASS);
        addTile(52, GRASS, ROAD, GRASS, ROAD);

        addTile(53, CITY, GRASS, GRASS, GRASS);
        addTile(54, GRASS, CITY, GRASS, GRASS);
        addTile(55, GRASS, GRASS, CITY, GRASS);
        addTile(56, GRASS, GRASS, GRASS, CITY);

        addTile(57, CITY, GRASS, ROAD, ROAD);
        addTile(58, ROAD, CITY, GRASS, ROAD);
        addTile(59, ROAD, ROAD, CITY, GRASS);
        addTile(60, GRASS, ROAD, ROAD, CITY);

        addTile(61, CITY, ROAD, ROAD, GRASS);
        addTile(62, GRASS, CITY, ROAD, ROAD);
        addTile(63, ROAD, GRASS, CITY, ROAD);
        addTile(64, ROAD, ROAD, GRASS, CITY);

        addTile(65, CITY, ROAD, ROAD, ROAD);
        addTile(66, ROAD, CITY, ROAD, ROAD);
        addTile(67, ROAD, ROAD, CITY, ROAD);
        addTile(68, ROAD, ROAD, ROAD, CITY);

        addTile(69, CITY, ROAD, GRASS, ROAD);
        addTile(70, ROAD, CITY, ROAD, GRASS);
        addTile(71, GRASS, ROAD, CITY, ROAD);
        addTile(72, ROAD, GRASS, ROAD, CITY);

        addTile(73, GRASS, GRASS, ROAD, ROAD);
        addTile(74, ROAD, GRASS, GRASS, ROAD);
        addTile(75, ROAD, ROAD, GRASS, GRASS);
        addTile(76, GRASS, ROAD, ROAD, GRASS);

        addTile(77, GRASS, ROAD, ROAD, ROAD);
        addTile(78, ROAD, GRASS, ROAD, ROAD);
        addTile(79, ROAD, ROAD, GRASS, ROAD);
        addTile(80, ROAD, ROAD, ROAD, GRASS);
    }

    private void addTile(int key, String up, String right, String down, String left) {
        tilesetRules.put(key, of(new TilesetRule(UP, up),
                new TilesetRule(RIGHT, right),
                new TilesetRule(DOWN, down),
                new TilesetRule(LEFT, left)));
    }

    @Override
    public List<TilesetRule> get(int index) {
        return tilesetRules.get(index);
    }

    @Override
    public int getTilesetCount() {
        return tilesetRules.size();
    }
}
