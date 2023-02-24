package com.visualg.animations.lsystems;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum LSystem {
    DRAGON_CURVE("F++F++F", 90, new HashMap<>() {{
        put('F', "F+G");
        put('G', "F-G");
    }}),
    FRACTAL_PLANT("X", 25, new HashMap<>() {{
        put('X', "F+[[X]-X]-F[-FX]+X");
        put('F', "FF");
    }}),
    KOCH_SNOWFLAKE("F", 60, new HashMap<>() {{
        put('F', "F-F++F-F");
    }}),
    PENTIGREE("F", 36, new HashMap<>() {{
        put('F', "F++F----F++F");
    }}),
    HILBERT_CURVE("L", 90, new HashMap<>() {{
        put('L', "+RF-LFL-FR+");
        put('R', "-LF+RFR+FL-");
    }}),
    GOSPER_CURVE("A", 60, new HashMap<>() {{
        put('A', "A-B--B+A++AA+B-");
        put('B', "+A-BB--B-A++A+B");
    }}),
    SIERPINSKI_TRIANGLE("A", 60, new HashMap<>() {{
        put('A', "B-A-B");
        put('B', "A+B+A");
    }}),
    SIERPINSKI_TRIANGLE2("F-G-G", 120, new HashMap<>() {{
        put('F', "F-G+F+G-F");
        put('G', "GG");
    }});

    private final String axiom;
    private final float angle;
    private final Map<Character, String> rules;

}
