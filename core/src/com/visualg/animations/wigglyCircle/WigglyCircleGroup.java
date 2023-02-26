package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.scenes.scene2d.Group;

import static com.visualg.animations.wigglyCircle.WigglyCircleSettings.settings;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class WigglyCircleGroup extends Group {

    public WigglyCircleGroup() {
        WigglyCircleAlg wigglyCircleAlg = new WigglyCircleAlg((float) WIDTH / 2, (float) HEIGHT / 2, settings);
        Table actor = new Table(settings);
        addActor(actor);
        addActor(new WigglyCircleActor(wigglyCircleAlg));
    }
}
