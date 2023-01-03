package com.visualg.animations.mouseFollower;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.visualg.ui.ShapeRendererActor;
import com.visualg.util.Mouse;

public class MouseFollowerActor extends ShapeRendererActor {
    private final Body body;

    public MouseFollowerActor() {
        super(ShapeRenderer.ShapeType.Filled);
        body = new Body();
    }

    @Override
    protected void drawFrame() {
        body.applyForceFrom(new Vector2(Mouse.getX(), Mouse.getY()));
        sr.circle(body.getPosition().x, body.getPosition().y, 50);
    }
}
