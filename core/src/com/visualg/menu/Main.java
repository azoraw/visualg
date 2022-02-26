package com.visualg.menu;

import com.badlogic.gdx.ApplicationAdapter;
import com.visualg.global.Config;

public class Main extends ApplicationAdapter {

    private MainStage mainStage;

    @Override
    public void create() {
        Config.initSkin();
        mainStage = new MainStage();
        TableMenu tableMenu = new TableMenu();
        mainStage.addActor(tableMenu);
        mainStage.addListener(new AnimationChangeListener(mainStage));
    }

    @Override
    public void render() {
        super.render();
        Config.refreshType.refresh();
        mainStage.draw();
    }
}
