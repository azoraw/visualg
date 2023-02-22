package com.visualg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.visualg.controls.MainStage;
import com.visualg.global.Config;
import com.visualg.ui.RefreshType;

public class Main extends ApplicationAdapter {

    private MainStage mainStage;

    @Override
    public void create() {

        Config.init();
        mainStage = new MainStage();
    }

    @Override
    public void render() {
        RefreshType.DEFAULT.refresh();
        mainStage.act(Gdx.graphics.getDeltaTime());
        mainStage.draw();
    }
}
