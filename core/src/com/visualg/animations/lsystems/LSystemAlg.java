package com.visualg.animations.lsystems;

import java.util.Map;

import static com.visualg.animations.lsystems.LSystemSettings.settings;

class LSystemAlg {

    private final Map<Character, String> rules = settings.getRules();

    String create(int generations) {
        String result = settings.getAxiom();
        for (int generation = 0; generation < generations; generation++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                char c = result.charAt(j);
                if (rules.containsKey(c)) {
                    sb.append(rules.get(c));
                } else {
                    sb.append(c);
                }
            }
            result = sb.toString();
        }
        return result;
    }
}
