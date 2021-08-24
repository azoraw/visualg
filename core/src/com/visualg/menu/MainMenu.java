package com.visualg.menu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.bezier.Bezier;

public class MainMenu extends ApplicationAdapter {

    Stage mainStage;
    TableMenu tableMenu;

    @Override
    public void create() {
        mainStage = new Stage();
        Gdx.input.setInputProcessor(mainStage);
        tableMenu = new TableMenu(this);
        mainStage.addActor(tableMenu);
    }

    @Override
    public void render() {
        super.render();
        mainStage.draw();
    }

    public void showAnimation(Animation animation) {
        mainStage.getActors()
                .first()
                .remove();

        mainStage.addActor(new Bezier());
    }

}
