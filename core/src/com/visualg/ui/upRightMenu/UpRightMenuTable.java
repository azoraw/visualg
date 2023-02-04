package com.visualg.ui.upRightMenu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.global.Config;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.DefaultTextField;

import static java.lang.Integer.parseInt;

public class UpRightMenuTable extends Table {

    public UpRightMenuTable() {
        setFillParent(true);
        right().top();
        add(new DefaultLabel("volume: "));
        add(new DefaultTextField("100",(volume) -> Config.musicController.setVolume(parseInt(volume))));
        add(new MuteMusicButton());
        add(new ExitButton());

    }
}
