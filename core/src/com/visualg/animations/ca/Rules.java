package com.visualg.animations.ca;

import java.util.HashMap;
import java.util.Map;

class Rules {

    private final int currentRule;
    private final Map<Integer, Boolean[]> rules = new HashMap<>();

    Rules(int ruleNo) {
        currentRule = ruleNo;
        initRules();
    }

    private void initRules() {
        for (int ruleNumber = 0; ruleNumber < 256; ruleNumber++) {
            Boolean[] rule = intToBoolArray(ruleNumber);
            rules.put(ruleNumber, rule);
        }
    }

    private Boolean[] intToBoolArray(int input) {
        Boolean[] boolArray = new Boolean[8];
        for (int i = 7; i >= 0; i--) {
            boolArray[i] = (input & (1 << i)) != 0;
        }
        return boolArray;
    }

    boolean getStateFor(boolean left, boolean middle, boolean right) {
        Boolean[] booleans = rules.get(currentRule);
        return booleans[booleansToInt(left, middle, right)];
    }

    private int booleansToInt(boolean... arr) {
        int n = 0;
        for (boolean b : arr)
            n = (n << 1) | (b ? 1 : 0);
        return n;
    }
}
