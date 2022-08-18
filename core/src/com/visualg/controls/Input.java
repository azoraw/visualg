package com.visualg.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Actor;

class Input {

    void addInputProcessors(Actor animationActor, MainStage mainStage) {
        if(animationActor instanceof InteractiveActor) {
            InputMultiplexer inputMultiplexer = new InputMultiplexer();
            inputMultiplexer.addProcessor(mainStage);
            inputMultiplexer.addProcessor(((InteractiveActor) animationActor).getInputProcessor());
            Gdx.input.setInputProcessor(inputMultiplexer);
        }
    }

    void addMainInputProcessor(MainStage mainStage) {
        Gdx.input.setInputProcessor(mainStage);
    }
}
