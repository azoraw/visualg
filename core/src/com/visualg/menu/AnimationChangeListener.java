package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;

class AnimationChangeListener implements EventListener {

    private final MainStage mainStage;

    AnimationChangeListener(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public boolean handle(Event event) {
        if (event instanceof ChangeAnimationEvent) {
            ChangeAnimationEvent changeAnimationEvent = (ChangeAnimationEvent) event;
            mainStage.showAnimation(changeAnimationEvent.getAnimation());
        }
        if (event instanceof MainMenuEvent) {
            mainStage.showMainMenu();
        }
        if (event instanceof RestartEvent) {
            mainStage.restart();
        }
        return false;
    }


}
