package com.visualg.animations.mouseFollower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.visualg.global.Config;
import com.visualg.util.libgdx.ShapeRendererActor;

public class MouseFollowerActor extends ShapeRendererActor {
    private final Body body;

    public MouseFollowerActor() {
        super(ShapeRenderer.ShapeType.Filled);
        body = new Body();
    }

    @Override
    protected void drawFrame() {
        body.applyForceFrom(new Vector2(Gdx.input.getX(), Config.HEIGHT - Gdx.input.getY()));
        sr.circle(body.getPosition().x, body.getPosition().y, 50);
    }
}
