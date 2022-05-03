package com.visualg.animations.ca;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Arrays;

class CellularAutomataAlg {

    public static final int NUMBER_OF_ROWS = 50;
    public static final int NUMBER_OF_COLUMNS = 81;

    private int currentRule = 0;
    private Rules rules;

    @Getter
    private ArrayDeque<Boolean[]> elements;

    CellularAutomataAlg(int ruleNo) {
        init(ruleNo);
    }

    private void init(int ruleNo) {
        elements = new ArrayDeque<>();
        rules = new Rules(ruleNo);
        Boolean[] e = new Boolean[NUMBER_OF_COLUMNS];
        Arrays.fill(e, false);
        e[NUMBER_OF_COLUMNS / 2] = true;
        elements.add(e);
    }

    void update() {
        if (elements.size() > NUMBER_OF_ROWS) {
            elements.pop();
        }
        Boolean[] cells = elements.getLast();
        elements.add(getNextState(cells));
    }

    private Boolean[] getNextState(Boolean[] cells) {
        Boolean[] newState = new Boolean[NUMBER_OF_COLUMNS];
        Arrays.fill(newState, false);
        for (int i = 1; i < cells.length - 1; i++) {
            boolean left = cells[i - 1];
            boolean middle = cells[i];
            boolean right = cells[i + 1];
            newState[i] = rules.getStateFor(left, middle, right);
        }
        return newState;
    }

    public void incrementRuleNumber() {
        incrementRule();
        init(currentRule);
    }

    private void incrementRule() {
        currentRule++;
        if (currentRule > 255) {
            currentRule = 0;
        }
    }
}
