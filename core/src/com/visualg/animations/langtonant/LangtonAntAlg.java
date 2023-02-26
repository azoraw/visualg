package com.visualg.animations.langtonant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.ArrayList;
import java.util.List;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.palette;

class LangtonAntAlg {

    private final boolean[][] board;
    private final List<Ant> ants;

    LangtonAntAlg() {
        board = new boolean[WIDTH][HEIGHT];
        ants = new ArrayList<>();
        ants.add(new Ant(WIDTH, HEIGHT));
    }

    void move() {
        for (Ant ant : ants) {
            if (board[ant.x][ant.y]) {
                ant.moveCounterClockwise();
            } else {
                ant.moveClockwise();
            }
            board[ant.x][ant.y] = !board[ant.x][ant.y];
        }

    }

    Pixmap getPixMap() {
        Pixmap pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(palette.getPrimaryColor());

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    pixmap.drawPixel(i, j);
                }
            }
        }
        pixmap.setColor(Color.RED);
        for (Ant ant : ants) {
            pixmap.drawPixel(ant.x, ant.y);
        }
        return pixmap;
    }
}
