package com.visualg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.visualg.global.Config;
import com.visualg.menu.MainStage;

public class Main extends ApplicationAdapter {

    private MainStage mainStage;

    @Override
    public void create() {
        Config.init();
        mainStage = new MainStage();
    }

    @Override
    public void render() {
        Config.refreshType.refresh();
        mainStage.act(Gdx.graphics.getDeltaTime());
        mainStage.draw();
    }
}
