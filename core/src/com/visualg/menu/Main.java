package com.visualg.menu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.global.Config;

public class Main extends ApplicationAdapter {

    private Stage mainStage;

    @Override
    public void create() {
        Config.initSkin();
        mainStage = new Stage();
        TableMenu tableMenu = new TableMenu();
        mainStage.addActor(tableMenu);
        mainStage.addListener(new AnimationChangeListener(mainStage));
    }

    @Override
    public void render() {
        super.render();
        mainStage.draw();
    }



}
