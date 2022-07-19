package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
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

        Actor animationActor = animation.getAnimation();
        this.addActor(animationActor);
        ToolbarTable backMenu = new ToolbarTable();
        this.addActor(backMenu);
        this.addActor(new ExitTable());
        //addInputProcessors(animationActor,backMenu);
    }

/*    private void addInputProcessors(Actor animationActor, ToolbarTable backMenu) {
        if(animationActor instanceof Fractal) {
            InputMultiplexer inputMultiplexer = new InputMultiplexer();
            inputMultiplexer.addProcessor(backMenu);
            inputMultiplexer.addProcessor(((Fractal) animationActor).getInputProcessor());
            Gdx.input.setInputProcessor(inputMultiplexer);
        }
    }*/

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
