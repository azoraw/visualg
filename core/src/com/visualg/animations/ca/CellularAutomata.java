package com.visualg.animations.ca;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.util.Scheduler;

import java.util.ArrayDeque;
import java.util.Iterator;


public class CellularAutomata extends Actor {

    private static final int CELL_SIZE = 20;
    private static final float UPDATE_PERIOD = 0.02f;
    private static final float INCREMENT_RULE_PERIOD = 10f;
    private static final Color ON_COLOR = Color.GRAY;
    private static final Color OFF_COLOR = Color.DARK_GRAY;
    private final ShapeRenderer sr;
    private final CellularAutomataAlg alg;


    public CellularAutomata() {
        int WIDTH = Gdx.graphics.getWidth();
        int HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(OFF_COLOR);

        alg = new CellularAutomataAlg(0);

        new Scheduler(alg::update, UPDATE_PERIOD);
        new Scheduler(alg::incrementRuleNumber, INCREMENT_RULE_PERIOD, INCREMENT_RULE_PERIOD);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        ArrayDeque<Boolean[]> elements = alg.getElements();
        int row = 0;
        Iterator<Boolean[]> it = elements.descendingIterator();

        while (it.hasNext()) {
            Boolean[] element = it.next();
            for (int i = 0; i < element.length; i++) {
                if (!element[i]) {
                    drawCell(row, i, OFF_COLOR);
                } else {
                    drawCell(row, i, ON_COLOR);
                }
            }
            row++;
        }
        sr.end();
        batch.begin();
    }

    private void drawCell(int row, int i, Color color) {
        sr.rect(i * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, color, color, color, color);
    }
}
