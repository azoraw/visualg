package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.global.Animation;

public class MainStage extends Stage {

    void showAnimation(Animation animation) {
        this.getActors()
                .clear();

        this.addActor(animation.getAnimation());
        AnimationTable backMenu = new AnimationTable();
        this.addActor(backMenu);
        this.addActor(new ExitTable());
    }

    void addTable() {
        MenuTable menuTable = new MenuTable();
        this.addActor(menuTable);
        this.addActor(new ExitTable());
    }

    public void showMainMenu() {
        this.getActors()
                .clear();
        addTable();
    }
}
