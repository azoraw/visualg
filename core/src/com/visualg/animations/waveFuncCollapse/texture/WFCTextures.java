package com.visualg.animations.waveFuncCollapse.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.visualg.animations.waveFuncCollapse.Settings;

import java.util.HashMap;
import java.util.Map;

public class WFCTextures {
    private static final String tile1Path = "wfc/tiles1.png";
    private static final String carrcasPath = "wfc/carrcas.png";
    private Map<Integer, Texture> texturesMap = new HashMap<>();

    public WFCTextures() {
        switch (Settings.INSTANCE.variant) {
            case VARIANT1, PSEUDO_RANDOM, VARIANT2 -> {
                TextureGenerator textureGenerator = new TextureGenerator();
                texturesMap = textureGenerator.generate();
            }
            case TILES1, TILES2, TILES3, TILES4, TILES5 -> initTiles1();
            case CARRCAS -> initCarcass();
            default -> throw new IllegalStateException("Unexpected value: " + Settings.INSTANCE.variant);
        }
    }

    private void initCarcass() {
        FileHandle file = Gdx.files.internal(carrcasPath);
        Pixmap allTiles = new Pixmap(file);
        int key = 0;
            for (int y = 0; y < 20; y++) {
                for (int x = 0; x < 4; x++) {
                    addcarrcasTile(allTiles, x * 85, y * 85, ++key);
            }
        }
        Pixmap pixmap = new Pixmap(85, 85, allTiles.getFormat());
        texturesMap.put(0, new Texture(pixmap));
    }

    private void initTiles1() {
        FileHandle file = Gdx.files.internal(tile1Path);
        Pixmap allTiles = new Pixmap(file);

        addTile1(allTiles, 0, 0, 1);
        addTile1(allTiles, 3, 0, 2);
        addTile1(allTiles, 6, 0, 3);
        addTile1(allTiles, 9, 0, 4);
        addTile1(allTiles, 0, 3, 5);
        addTile1(allTiles, 3, 3, 6);
        addTile1(allTiles, 6, 3, 7);
        addTile1(allTiles, 9, 3, 8);
        addTile1(allTiles, 0, 6, 9);
        addTile1(allTiles, 3, 6, 10);
        addTile1(allTiles, 6, 6, 11);
        addTile1(allTiles, 9, 6, 12);
        addTile1(allTiles, 0, 9, 13);
        addTile1(allTiles, 3, 9, 14);
        addTile1(allTiles, 6, 9, 15);
        addTile1(allTiles, 9, 9, 16);
        addTile1(allTiles, 0, 12, 17);
        addTile1(allTiles, 3, 12, 18);
        addTile1(allTiles, 6, 12, 0);
    }

    private void addTile1(Pixmap allTiles, int srcx, int srcy, int key) {
        Pixmap pixmap = new Pixmap(3, 3, allTiles.getFormat());
        pixmap.drawPixmap(allTiles, 0, 0, srcx, srcy, 3, 3);
        texturesMap.put(key, new Texture(pixmap));
    }

    private void addcarrcasTile(Pixmap allTiles, int srcx, int srcy, int key) {
        Pixmap pixmap = new Pixmap(85, 85, allTiles.getFormat());
        pixmap.drawPixmap(allTiles, 0, 0, srcx, srcy, 85, 85);
        texturesMap.put(key, new Texture(pixmap));
    }

    public Texture get(int index) {
        return texturesMap.get(index);
    }
}
