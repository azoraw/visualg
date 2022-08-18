package com.visualg.controls;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.animations.Animation;
import com.visualg.ui.animationToolbar.ToolbarTable;
import com.visualg.ui.exit.ExitTable;
import com.visualg.ui.menu.MenuTable;

public class MainStage extends Stage {

    private final Input input = new Input();
    private Animation currentAnimation;

    public MainStage() {
        addListener(new MainStageEventListener(this));
        addMenuTable();
        input.addMainInputProcessor(this);
    }

    public void restart() {
        showAnimation(currentAnimation);
    }

    public void showAnimation(Animation animation) {
        currentAnimation = animation;
        clearStage();

        Actor animationActor = animation.getAnimation();
        addActor(animationActor);
        addActor(new ToolbarTable());
        addActor(new ExitTable());

        input.addInputProcessors(animationActor, this);
    }

    public void addMenuTable() {
        MenuTable menuTable = new MenuTable();
        addActor(menuTable);
        addActor(new ExitTable());
    }

    public void showMainMenu() {
        clearStage();
        addMenuTable();
        input.addMainInputProcessor(this);
    }

    private void clearStage() {
        getActors()
                .clear();
    }
}