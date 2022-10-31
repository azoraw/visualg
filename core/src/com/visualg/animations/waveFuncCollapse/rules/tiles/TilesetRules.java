package com.visualg.animations.waveFuncCollapse.rules.tiles;

import java.util.List;

public interface TilesetRules {
    List<TilesetRule> get(int index);
    int getTilesetCount();
}
