package com.visualg.ui.upRightMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.controls.events.ChangeUiScalingEvent;
import com.visualg.global.Config;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.DefaultTextField;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class UpRightMenuTable extends Table {

    public UpRightMenuTable() {
        setFillParent(true);
        right().top();
        add(new DefaultLabel("uiscale: "));
        add(new DefaultTextField("" + Config.getUserProperties().getUiScale(), (scale) -> fire(new ChangeUiScalingEvent(parseFloat(scale)))));
        add(new DefaultLabel("volume: "));
        add(new DefaultTextField("" + Config.getUserProperties().getVolume(), (volume) -> Config.musicController.setVolume(parseInt(volume))));
        add(new MuteMusicButton());
        add(new DefaultButton("X", () -> Gdx.app.exit()));

    }
}
