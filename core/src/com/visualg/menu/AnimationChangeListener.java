package com.visualg.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;

class AnimationChangeListener implements EventListener {

    private final MainStage mainStage;

    public AnimationChangeListener(MainStage mainStage) {
        this.mainStage = mainStage;
        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public boolean handle(Event event) {
        if (event instanceof ChangeAnimationEvent) {
            ChangeAnimationEvent changeAnimationEvent = (ChangeAnimationEvent) event;
            mainStage.showAnimation(changeAnimationEvent.getAnimation());
        }
        return false;
    }


}
