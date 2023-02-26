package com.visualg.animations.qtree.qtree2;

import com.visualg.global.Config;
import lombok.Getter;

import static com.visualg.util.RandomDecorator.Random;

@Getter
class Particle {
    private final float x;
    private final float y;

    public Particle() {
        x = Random.getRandomFloat(Config.WIDTH);
        y = Random.getRandomFloat(Config.HEIGHT);
    }
}
