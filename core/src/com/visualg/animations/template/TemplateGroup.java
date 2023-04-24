package com.visualg.animations.template;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TemplateGroup extends Group {

    public TemplateGroup() {
        addActor(new Table());
        addActor(new TemplateActor());
    }
}
