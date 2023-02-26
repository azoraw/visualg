package com.visualg.animations.ca;

import com.badlogic.gdx.graphics.Color;
import com.visualg.ui.ShapeRendererActor;

import java.util.ArrayDeque;
import java.util.Iterator;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;


class CellularAutomataActor extends ShapeRendererActor {

    private static final int CELL_SIZE = 20;
    private static final Color ON_COLOR = Color.GRAY;
    private static final Color OFF_COLOR = Color.DARK_GRAY;
    private final CellularAutomataAlg alg;
    private final CASettings CASettings;

    private int animationSpeedFrameCounter = 0;
    private int ruleSpeedFrameCounter = 0;


    CellularAutomataActor(CellularAutomataAlg cellularAutomataAlg) {
        super(Filled);
        sr.setColor(OFF_COLOR);

        alg = cellularAutomataAlg;
        CASettings = cellularAutomataAlg.getCASettings();
    }

    @Override
    protected void drawFrame() {
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
        update();
    }

    private void update() {
        animationSpeedFrameCounter++;
        ruleSpeedFrameCounter++;

        if (animationSpeedFrameCounter > CASettings.getAnimationSpeedInSec() * 60) {
            alg.update();
            animationSpeedFrameCounter = 0;
        }

        if (ruleSpeedFrameCounter > CASettings.getRuleChangeSpeedInSec() * 60) {
            alg.incrementRuleNumber();
            ruleSpeedFrameCounter = 0;
        }
    }

    private void drawCell(int col, int row, Color color) {
        sr.rect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, color, color, color, color);
    }
}
