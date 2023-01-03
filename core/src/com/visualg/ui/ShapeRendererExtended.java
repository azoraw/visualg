package com.visualg.ui;

import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class ShapeRendererExtended extends ShapeRenderer {

    private final ImmediateModeRenderer renderer;

    public ShapeRendererExtended() {
        renderer = super.getRenderer();
    }

    /**
     * Draws an arc without linking rotation and end point.
     */
    public void arc2(float x, float y, float radius, float rotation, float degrees) {
        int segments = (int) (6 * (float) Math.cbrt(radius) * (degrees / 360.0f));

        if (segments <= 0) return;
        float colorBits = super.getColor().toFloatBits();
        float theta = (2 * MathUtils.PI * (degrees / 360.0f)) / segments;
        float cos = MathUtils.cos(theta);
        float sin = MathUtils.sin(theta);
        float cx = radius * MathUtils.cos(rotation * MathUtils.degreesToRadians);
        float cy = radius * MathUtils.sin(rotation * MathUtils.degreesToRadians);

        for (int i = 0; i < segments; i++) {
            renderer.color(colorBits);
            renderer.vertex(x + cx, y + cy, 0);
            float temp = cx;
            cx = cos * cx - sin * cy;
            cy = sin * temp + cos * cy;
            renderer.color(colorBits);
            renderer.vertex(x + cx, y + cy, 0);
        }
    }
}

