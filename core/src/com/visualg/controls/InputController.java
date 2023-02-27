package com.visualg.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Actor;

class InputController {

    void setAnimationInputProcessor(Actor animationActor, VisualgStage visualgStage) {
        if (animationActor instanceof InteractiveActor interactiveAnimationActor) {
            InputMultiplexer inputMultiplexer = new InputMultiplexer();
            inputMultiplexer.addProcessor(visualgStage);
            inputMultiplexer.addProcessor(interactiveAnimationActor.getInputProcessor());
            Gdx.input.setInputProcessor(inputMultiplexer);
        }
    }

    void setMainStageInputProcessor(VisualgStage visualgStage) {
        Gdx.input.setInputProcessor(visualgStage);
    }
}
