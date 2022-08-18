package com.visualg.animations.circleStacking;

import com.badlogic.gdx.math.Vector2;
import com.visualg.global.Config;

import java.util.ArrayList;
import java.util.List;

class CircleStackingAlg {

    private final List<Circle> circles = new ArrayList<>();

    CircleStackingAlg() {
        CircleStackingSettings settings = CircleStackingSettings.INSTANCE;
        circles.add(Circle.builder()
                .xCenter(Config.WIDTH/2)
                .yCenter(Config.HEIGHT/2)
                .radius(settings.getCircles().get(0).first)
                .stepsNo(settings.getCircles().get(0).second)
                .build());

        for (int i = 1; i < settings.getNumberOfCircles(); i++) {
            circles.add(Circle.builder()
                    .xCenter((int)circles.get(i-1).getEnd().x)
                    .yCenter((int)circles.get(i-1).getEnd().y)
                    .radius(settings.getCircles().get(i).first)
                    .stepsNo(settings.getCircles().get(i).second)
                    .build());
        }
    }

    void update() {
        circles.get(0).update(Config.WIDTH/2,Config.HEIGHT/2);
        for (int i = 1; i < circles.size(); i++) {
            circles.get(i).update((int)circles.get(i-1).getEnd().x,(int) circles.get(i-1).getEnd().y);
        }
    }

    Vector2 getLastCircle() {
        int index = circles.size() - 1;
        return circles.get(index).getEnd();
    }

    Vector2 getSecondLastCircle() {
        int index = circles.size() - 2;
        return circles.get(index).getEnd();
    }
}
