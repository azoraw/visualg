package com.visualg.animations.lsystems;

import com.visualg.global.Config;
import lombok.Data;

import java.util.HashMap;

@Data
class Settings {
    static final Settings Settings = new Settings();

    float transparency = 1f;
    int numberOfGenerations = 2;
    int xStart = Config.WIDTH/2;
    int yStart = Config.HEIGHT/2;
    int angleStart = 0;
    float distance = 10;
    float rotateLeft = 60;
    float rotateRight = -60;
    String axiom = KochSnowflakeRules.axiom;
    HashMap<Character, String> rules = KochSnowflakeRules.init();

}
