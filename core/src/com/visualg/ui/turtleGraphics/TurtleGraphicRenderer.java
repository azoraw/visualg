package com.visualg.ui.turtleGraphics;

import com.visualg.global.Config;
import com.visualg.ui.FrameBufferActor;

import java.util.Stack;

public abstract class TurtleGraphicRenderer extends FrameBufferActor implements TurtleGraphics {

    private final Stack<State> stack;
    private State currentState;

    public TurtleGraphicRenderer(int xStart, int yStart, float angleStart) {
        super(true);
        stack = new Stack<>();
        currentState = new State(xStart, yStart, angleStart);
        sr.setColor(Config.palette.getPrimaryColor());
    }

    @Override
    public void move(float distance) {
        float newX = currentState.x + distance * (float) Math.cos(Math.toRadians(currentState.angle));
        float newY = currentState.y + distance * (float) Math.sin(Math.toRadians(currentState.angle));
        sr.rectLine(currentState.x, currentState.y, newX, newY, 1);
        currentState.x = newX;
        currentState.y = newY;
    }

    @Override
    public void rotate(float angle) {
        currentState.angle += angle;
    }

    @Override
    public void teleport(float distance) {
        currentState.x += distance * (float) Math.cos(Math.toRadians(currentState.angle));
        currentState.y += distance * (float) Math.sin(Math.toRadians(currentState.angle));
    }

    @Override
    public void pushState() {
        stack.push(new State(currentState.x, currentState.y, currentState.angle));
    }

    @Override
    public void popState() {
        currentState = stack.pop();
    }
}
