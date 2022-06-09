package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.scenes.scene2d.Group;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class WigglyCircleGroup extends Group {

    public WigglyCircleGroup() {
        CurrentSettings currentSettings = new CurrentSettings();
        WigglyCircleAlg wigglyCircleAlg = new WigglyCircleAlg((float) WIDTH / 2, (float) HEIGHT / 2,
                currentSettings);
        WigglyCircleSettingsTable actor = new WigglyCircleSettingsTable(currentSettings);
        this.addActor(actor);
        this.addActor(new WigglyCircleActor(wigglyCircleAlg));
    }
}
