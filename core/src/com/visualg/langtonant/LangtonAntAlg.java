package com.visualg.langtonant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.ArrayList;
import java.util.List;

class LangtonAntAlg {

    private final int width;
    private final int height;
    private boolean[][] board;
    private final List<Ant> ants;

    LangtonAntAlg(int width, int height) {
        this.width = width;
        this.height = height;
        board = new boolean[width][height];
        ants = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

            ants.add(new Ant(width, height));
        }

    }

    public void move() {
        for (Ant ant : ants) {
            if (board[ant.x][ant.y]) {
                ant.moveCounterClockwise();
            } else {
                ant.moveClockwise();
            }
            board[ant.x][ant.y] = !board[ant.x][ant.y];
        }

    }

    public Pixmap getPixMap() {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.WHITE);

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
