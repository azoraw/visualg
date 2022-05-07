package com.visualg.animations.ca;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayDeque;
import java.util.Iterator;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;


public class CellularAutomataActor extends Actor {

    private static final int CELL_SIZE = 20;
    private static final Color ON_COLOR = Color.GRAY;
    private static final Color OFF_COLOR = Color.DARK_GRAY;
    private final ShapeRenderer sr;
    private final CellularAutomataAlg alg;
    private final CurrentSettings settings;

    private int animationSpeedFrameCounter = 0;
    private int ruleSpeedFrameCounter = 0;


    public CellularAutomataActor(CellularAutomataAlg cellularAutomataAlg) {
        int WIDTH = Gdx.graphics.getWidth();
        int HEIGHT = Gdx.graphics.getHeight();
        sr = new ShapeRenderer();
        sr.setColor(OFF_COLOR);

        alg = cellularAutomataAlg;
        settings = cellularAutomataAlg.getCurrentSettings();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        sr.begin(Filled);
        ArrayDeque<Boolean[]> elements = alg.getElements();
        int row = 0;
        Iterator<Boolean[]> it = elements.descendingIterator();

        while (it.hasNext()) {
            Boolean[] element = it.next();
            for (int i = 0; i < element.length; i++) {
                if (!element[i]) {
                    drawCell(i, row, OFF_COLOR);
                } else {
                    drawCell(i, row, ON_COLOR);
                }
            }
            row++;
        }
        sr.end();
        update();
        batch.begin();
    }

    private void update() {
        animationSpeedFrameCounter++;
        ruleSpeedFrameCounter++;

        if (animationSpeedFrameCounter > settings.getAnimationSpeedInSec() * 60) {
            alg.update();
            animationSpeedFrameCounter = 0;
        }

        if (ruleSpeedFrameCounter > settings.getRuleChangeSpeedInSec() * 60) {
            alg.incrementRuleNumber();
            ruleSpeedFrameCounter = 0;
        }
    }

    private void drawCell(int col, int row, Color color) {
        sr.rect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, color, color, color, color);
    }
}
