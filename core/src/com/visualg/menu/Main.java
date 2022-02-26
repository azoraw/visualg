package com.visualg.menu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.visualg.global.Config;

public class Main extends ApplicationAdapter {

    private MainStage mainStage;

    @Override
    public void create() {
        Config.initSkin();
        mainStage = new MainStage();
        mainStage.addListener(new AnimationChangeListener(mainStage));
        mainStage.addTable();
    }

    @Override
    public void render() {
        Config.refreshType.refresh();
        mainStage.act(Gdx.graphics.getDeltaTime());
        mainStage.draw();
    }
}
