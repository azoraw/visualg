package com.visualg.controls;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.animations.Animation;
import com.visualg.global.Config;
import com.visualg.ui.animationToolbar.AnimationToolbarTable;
import com.visualg.ui.menu.AnimationsTable;
import com.visualg.ui.upRightMenu.OptionsTable;

public class VisualgStage extends Stage {

    private final InputController inputController = new InputController();

    public VisualgStage() {
        addListener(new UserInputEventListener(this));
        showMainMenu();
    }

    public void restart() {
        showAnimation(Config.getCurrentAnimation());
    }

    public void showAnimation(Animation animation) {
        clearStage();
        Config.setCurrentAnimation(animation);

        Actor animationActor = animation.getAnimation();
        addActor(animationActor);
        addActor(new AnimationToolbarTable());
        addActor(new OptionsTable());

        inputController.setAnimationInputProcessor(animationActor, this);
    }

    public void showMainMenu() {
        clearStage();
        Config.setCurrentAnimation(null);
        addMainMenuTables();
        inputController.setMainStageInputProcessor(this);
    }

    private void addMainMenuTables() {
        addActor(new AnimationsTable());
        addActor(new OptionsTable());
    }

    private void clearStage() {
        getActors().clear();
    }
}
