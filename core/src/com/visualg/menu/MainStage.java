package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.animations.Animation;
import com.visualg.util.libgdx.ui.exit.ExitTable;

public class MainStage extends Stage {

    private Animation currentAnimation;

    public MainStage() {
        this.addListener(new AnimationChangeListener(this));
        this.addMenuTable();
    }

    void showAnimation(Animation animation) {
        currentAnimation = animation;
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

    public void restart() {
        showAnimation(currentAnimation);
    }
}
