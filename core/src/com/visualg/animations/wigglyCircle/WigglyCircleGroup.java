package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

public class WigglyCircleGroup extends Group {

    public WigglyCircleGroup() {
        CurrentSettings currentSettings = new CurrentSettings();
        WigglyCircleAlg wigglyCircleAlg = new WigglyCircleAlg((float) Gdx.graphics.getWidth() / 2,
                (float) Gdx.graphics.getHeight() / 2,
                currentSettings);
        WigglyCircleSettings actor = new WigglyCircleSettings(currentSettings);
        this.addActor(actor);
        this.addActor(new WigglyCircleActor(wigglyCircleAlg));
    }
}
