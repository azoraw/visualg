package com.visualg.animations.lsystems;

import com.visualg.global.Config;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
class Settings {
    static Settings Settings = new Settings();

    float transparency = 1f;
    int numberOfGenerations = 2;
    int xStart = Config.WIDTH / 2;
    int yStart = Config.HEIGHT / 2;
    int angleStart = 0;
    float distance = 10;

    LSystem lSystem = LSystem.DRAGON_CURVE;
    float rotateLeft = lSystem.getAngle();
    float rotateRight = -1 * lSystem.getAngle();
    String axiom = lSystem.getAxiom();
    Map<Character, String> rules = lSystem.getRules();

    void restart() {
        rotateLeft = lSystem.getAngle();
        rotateRight = -1 * lSystem.getAngle();
        axiom = lSystem.getAxiom();
        rules = lSystem.getRules();
    }
}
