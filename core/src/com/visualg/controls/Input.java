package com.visualg.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Actor;

class Input {

    void addInputProcessors(Actor animationActor, MainStage mainStage) {
        if (animationActor instanceof InteractiveActor interactiveAnimationActor) {
            InputMultiplexer inputMultiplexer = new InputMultiplexer();
            inputMultiplexer.addProcessor(mainStage);
            inputMultiplexer.addProcessor(interactiveAnimationActor.getInputProcessor());
            Gdx.input.setInputProcessor(inputMultiplexer);
        }
    }

    void addMainInputProcessor(MainStage mainStage) {
        Gdx.input.setInputProcessor(mainStage);
    }
}
