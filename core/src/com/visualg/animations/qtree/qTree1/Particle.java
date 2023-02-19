package com.visualg.animations.qtree.qTree1;

import com.visualg.global.Config;
import lombok.Getter;

import static com.visualg.util.RandomDecorator.Random;

@Getter
class Particle {
    private float x;
    private float y;

    public Particle() {
        x = Random.getRandomFloat(Config.WIDTH);
        y = Random.getRandomFloat(Config.HEIGHT);
    }
}
