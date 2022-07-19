package com.visualg.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.animations.Animation;
import com.visualg.util.libgdx.InteractiveActor;
import com.visualg.util.libgdx.ui.exit.ExitTable;

public class MainStage extends Stage {

    private Animation currentAnimation;

    public MainStage() {
        this.addListener(new AnimationChangeListener(this));
        this.addMenuTable();
        addMainInputProcessor();
    }

    void showAnimation(Animation animation) {
        currentAnimation = animation;
        this.getActors()
                .clear();

        Actor animationActor = animation.getAnimation();
        this.addActor(animationActor);
        ToolbarTable backMenu = new ToolbarTable();
        this.addActor(backMenu);
        this.addActor(new ExitTable());
        addInputProcessors(animationActor);
    }

    private void addInputProcessors(Actor animationActor) {
        if(animationActor instanceof InteractiveActor) {
            InputMultiplexer inputMultiplexer = new InputMultiplexer();
            inputMultiplexer.addProcessor(this);
            inputMultiplexer.addProcessor(((InteractiveActor) animationActor).getInputProcessor());
            Gdx.input.setInputProcessor(inputMultiplexer);
        }
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
        addMainInputProcessor();
    }

    void addMainInputProcessor() {
        Gdx.input.setInputProcessor(this);
    }

    public void restart() {
        showAnimation(currentAnimation);
    }
}
