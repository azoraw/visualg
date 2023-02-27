package com.visualg.controls;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.visualg.controls.events.ChangeAnimationEvent;
import com.visualg.controls.events.ChangeUiScalingEvent;
import com.visualg.controls.events.MainMenuEvent;
import com.visualg.controls.events.RestartEvent;

class UserInputEventListener implements EventListener {

    private final VisualgStage visualgStage;

    UserInputEventListener(VisualgStage visualgStage) {
        this.visualgStage = visualgStage;
    }

    @Override
    public boolean handle(Event event) {
        if (event instanceof ChangeAnimationEvent changeAnimationEvent) {
            visualgStage.showAnimation(changeAnimationEvent.getAnimation());
        }
        if (event instanceof MainMenuEvent) {
            visualgStage.showMainMenu();
        }
        if (event instanceof RestartEvent) {
            visualgStage.restart();
        }
        if (event instanceof ChangeUiScalingEvent changeUiScalingEvent) {
            visualgStage.changeUiScaling(changeUiScalingEvent.getNewValue());
        }
        return false;
    }
}
