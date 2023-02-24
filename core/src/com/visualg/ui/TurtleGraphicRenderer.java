package com.visualg.ui;

import com.visualg.global.Config;

public abstract class TurtleGraphicRenderer extends FrameBufferActor implements TurtleGraphics {

    private float x, y;
    private float angle;

    public TurtleGraphicRenderer(int xStart, int yStart) {
        super(true);
        x = xStart;
        y = yStart;
        sr.setColor(Config.palette.getPrimaryColor());
    }

    @Override
    public void move(float distance) {
        float newX = x + distance * (float) Math.cos(Math.toRadians(angle));
        float newY = y + distance * (float) Math.sin(Math.toRadians(angle));
        sr.rectLine(x, y, newX, newY, 1);
        x = newX;
        y = newY;
    }

    @Override
    public void rotate(float angle) {
        this.angle += angle;
    }

    @Override
    public void teleport(float distance) {
        x += distance * (float) Math.cos(Math.toRadians(angle));
        y += distance * (float) Math.sin(Math.toRadians(angle));
    }

    @Override
    public void pushState() {

    }

    @Override
    public void popState() {

    }
}
