package com.visualg.controls;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.animations.Animation;
import com.visualg.global.Config;
import com.visualg.ui.animationToolbar.ToolbarTable;
import com.visualg.ui.menu.MenuTable;
import com.visualg.ui.upRightMenu.UpRightMenuTable;

public class MainStage extends Stage {

    private final Input input = new Input();

    public MainStage() {
        addListener(new MainStageEventListener(this));
        addMenuTable();
        input.addMainInputProcessor(this);
    }

    public void restart() {
        showAnimation(Config.getCurrentAnimation());
    }

    public void showAnimation(Animation animation) {
        Config.setCurrentAnimation(animation);
        clearStage();

        Actor animationActor = animation.getAnimation();
        addActor(animationActor);
        addActor(new ToolbarTable());
        addActor(new UpRightMenuTable());

        input.addInputProcessors(animationActor, this);
    }

    public void addMenuTable() {
        MenuTable menuTable = new MenuTable();
        addActor(menuTable);
        addActor(new UpRightMenuTable());
    }

    public void showMainMenu() {
        clearStage();
        addMenuTable();
        input.addMainInputProcessor(this);
    }

    private void clearStage() {
        getActors().clear();
    }

    public void changeUiScaling(float newValue) {
        Config.updateUiFontScale(newValue);
        if (Config.getCurrentAnimation() == null) {
            showMainMenu();
        } else {
            showAnimation(Config.getCurrentAnimation());
        }
    }
}
