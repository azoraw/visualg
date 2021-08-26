package com.visualg.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.visualg.global.Animation;

class AnimationChangeListener implements EventListener {

    private final Stage mainStage;

    public AnimationChangeListener(Stage mainStage) {
        this.mainStage = mainStage;
        Gdx.input.setInputProcessor(mainStage);
    }

    @Override
    public boolean handle(Event event) {
        if (event instanceof ChangeAnimationEvent) {
            ChangeAnimationEvent changeAnimationEvent = (ChangeAnimationEvent) event;
            showAnimation(changeAnimationEvent.getAnimation());
        }
        return false;
    }

    private void showAnimation(Animation animation) {
         mainStage.getActors()
                .first()
                .remove();

        mainStage.addActor(animation.getAnimation());
    }
}
