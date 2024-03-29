package com.visualg.animations.labyrinth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.visualg.util.Direction;

import java.util.HashMap;
import java.util.Map;

import static com.visualg.animations.labyrinth.LabyrinthGeneratorActor.CELL_HEIGHT;
import static com.visualg.animations.labyrinth.LabyrinthGeneratorActor.CELL_WIDTH;

class TextureFactory {

    static Map<Direction, Texture> createWallTextures() {
        Map<Direction, Texture> wallTextures = new HashMap<>();

        wallTextures.put(Direction.LEFT, new Texture(createScaledCell(Gdx.files.internal("labyrinth/LEFT.png"))));
        wallTextures.put(Direction.RIGHT, new Texture(createScaledCell(Gdx.files.internal("labyrinth/RIGHT.png"))));
        wallTextures.put(Direction.DOWN, new Texture(createScaledCell(Gdx.files.internal("labyrinth/DOWN.png"))));
        wallTextures.put(Direction.UP, new Texture(createScaledCell(Gdx.files.internal("labyrinth/UP.png"))));

        return wallTextures;
    }

    static Map<Color, Texture> createBackgroundTextures() {
        Map<Color, Texture> backgroundTextures = new HashMap<>();

        backgroundTextures.put(Color.RED, new Texture(createScaledCell(Gdx.files.internal("labyrinth/Red.png"))));
        backgroundTextures.put(Color.GREEN, new Texture(createScaledCell(Gdx.files.internal("labyrinth/Green.png"))));
        backgroundTextures.put(Color.BLUE, new Texture(createScaledCell(Gdx.files.internal("labyrinth/Blue.png"))));
        backgroundTextures.put(Color.WHITE, new Texture(createScaledCell(Gdx.files.internal("labyrinth/WhiteCentered.png"))));

        return backgroundTextures;
    }

    private static Pixmap createScaledCell(FileHandle file) {
        Pixmap pixmap = new Pixmap(file);
        Pixmap scaledPixmap = new Pixmap(CELL_WIDTH, CELL_HEIGHT, pixmap.getFormat());
        scaledPixmap.drawPixmap(pixmap,
                0, 0, pixmap.getWidth(), pixmap.getHeight(),
                0, 0, scaledPixmap.getWidth(), scaledPixmap.getHeight()
        );
        return scaledPixmap;
    }
}
