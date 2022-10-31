package com.visualg.animations.waveFuncCollapse.texture;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.visualg.global.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class TextureGenerator {
    private final Map<Integer, Texture> texturesMap = new HashMap<>();
    private final int cellSize;
    private final TextureRules textureRules;

    TextureGenerator() {
        textureRules = new TextureRules();
        cellSize = textureRules.getCellSize();
    }

    public Map<Integer, Texture> generate() {
        for (TextureRule rule : textureRules.getRules()) {
            texturesMap.put(rule.indexElement(), createTexture(rule.activeCellsFunction()));
        }
        texturesMap.put(0, getEmpty());
        return texturesMap;
    }

    private Texture createTexture(BiFunction<Integer, Integer, Boolean> activeCellsFunction) {
        Pixmap pixmap = getEmptyPixmap();
        for (int x = 0; x < cellSize; x++) {
            for (int y = 0; y < cellSize; y++) {
                if (activeCellsFunction.apply(x, y)) {
                    pixmap.drawPixel(x, y);
                }
            }
        }
        return new Texture(pixmap);
    }

    private Texture getEmpty() {
        Pixmap emptyPixmap = getEmptyPixmap();
        emptyPixmap.setColor(Color.BLACK);
        emptyPixmap.fill();
        return new Texture(emptyPixmap);
    }

    private Pixmap getEmptyPixmap() {
        Pixmap pixmap = new Pixmap(cellSize, cellSize, Pixmap.Format.RGBA8888);
        pixmap.setColor(Config.palette.getBackground());
        pixmap.fill();
        pixmap.setColor(Config.palette.getPrimaryColor());
        return pixmap;
    }
}
