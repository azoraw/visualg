package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.global.Animation;
import com.visualg.ui.exit.ExitTable;

public class MainStage extends Stage {

    public MainStage() {
        this.addListener(new AnimationChangeListener(this));
        this.addMenuTable();
    }

    void showAnimation(Animation animation) {
        this.getActors()
                .clear();

        this.addActor(animation.getAnimation());
        AnimationTable backMenu = new AnimationTable();
        this.addActor(backMenu);
        this.addActor(new ExitTable());
    }

    public void addMenuTable() {
        MenuTable menuTable = new MenuTable();
        this.addActor(menuTable);
        this.addActor(new ExitTable());
    }

    public void showMainMenu() {
        this.getActors()
                .clear();
        addMenuTable();
    }
}
