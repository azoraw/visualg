package com.visualg.animations.lsystems;

import java.util.HashMap;

class KochSnowflakeRules {
    private static final Character ruleKey = 'F';
    private static final String ruleValue = "F-F++F-F";
    static final String axiom = "F++F++F";

    static HashMap<Character, String> init() {
        final HashMap<Character, String> map = new HashMap<>();
        map.put(ruleKey, ruleValue);
        return map;
    }
}
