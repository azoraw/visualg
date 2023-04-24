package com.visualg.animations.template;

import com.visualg.ui.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

class TemplateActor extends ShapeRendererActor {

    private final TemplateAlg alg;

    TemplateActor() {
        super(Line);
        this.alg = new TemplateAlg();
    }

    @Override
    protected void drawFrame() {
        alg.update();
    }
}
