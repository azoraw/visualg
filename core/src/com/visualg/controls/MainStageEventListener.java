package com.visualg.controls;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.visualg.controls.events.ChangeAnimationEvent;
import com.visualg.controls.events.ChangeUiScalingEvent;
import com.visualg.controls.events.MainMenuEvent;
import com.visualg.controls.events.RestartEvent;

class MainStageEventListener implements EventListener {

    private final MainStage mainStage;

    MainStageEventListener(MainStage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public boolean handle(Event event) {
        if (event instanceof ChangeAnimationEvent changeAnimationEvent) {
            mainStage.showAnimation(changeAnimationEvent.getAnimation());
        }
        if (event instanceof MainMenuEvent) {
            mainStage.showMainMenu();
        }
        if (event instanceof RestartEvent) {
            mainStage.restart();
        }
        if (event instanceof ChangeUiScalingEvent changeUiScalingEvent) {
            mainStage.changeUiScaling(changeUiScalingEvent.getNewValue());
        }
        return false;
    }


}
