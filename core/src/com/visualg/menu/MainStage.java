package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.global.Animation;

public class MainStage extends Stage {

    void showAnimation(Animation animation) {
        this.getActors()
                .first()
                .remove();

        this.addActor(animation.getAnimation());
        AnimationTable actor = new AnimationTable();
        this.addActor(actor);
    }

    void addTable() {
        MenuTable menuTable = new MenuTable();
        this.addActor(menuTable);
    }

    public void showMainMenu() {
        this.getActors()
                .clear();
        addTable();
    }
}
