package com.visualg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.visualg.controls.VisualgStage;
import com.visualg.global.Config;
import com.visualg.ui.RefreshType;

public class Visualg extends ApplicationAdapter {

    private VisualgStage visualgStage;

    @Override
    public void create() {

        Config.init();
        visualgStage = new VisualgStage();
    }

    @Override
    public void render() {
        RefreshType.DEFAULT.refresh();
        visualgStage.act(Gdx.graphics.getDeltaTime());
        visualgStage.draw();
    }
}
