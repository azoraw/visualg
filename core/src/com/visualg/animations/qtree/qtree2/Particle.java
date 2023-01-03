package com.visualg.animations.qtree.qtree2;

import com.visualg.global.Config;
import com.visualg.util.RandomGenerator;
import lombok.Getter;

@Getter
class Particle {
    private float x;
    private float y;

    public Particle() {
        x = RandomGenerator.getRandomFloat(Config.WIDTH);
        y = RandomGenerator.getRandomFloat(Config.HEIGHT);
    }
}
