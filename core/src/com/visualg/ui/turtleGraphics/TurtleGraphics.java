package com.visualg.ui.turtleGraphics;

public interface TurtleGraphics {
    void move(float distance);

    void rotate(float angle);

    void teleport(float distance);

    void pushState();

    void popState();
}
