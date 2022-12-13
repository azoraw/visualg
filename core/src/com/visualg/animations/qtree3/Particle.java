package com.visualg.animations.qtree3;

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

    public void moveRandom() {
        x += RandomGenerator.getIntInRange(3) - 1;
        y += RandomGenerator.getIntInRange(3) - 1;
    }
}
