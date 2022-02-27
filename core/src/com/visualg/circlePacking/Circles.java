package com.visualg.circlePacking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.util.RandomGenerator;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;

public class Circles {
    int HOW_MANY_CIRCLES = 100;

    private final int WIDTH;
    private final int HEIGHT;
    private final ArrayList<Circle> circles = new ArrayList<>();
    private final Pixmap pixmap;

    public Circles(Pixmap pixmapResized) {
        this.pixmap = pixmapResized;
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        circles.add(createCircle());
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public void update() {

        for (int i = 0; i < HOW_MANY_CIRCLES; i++) {
            addNewCircle();
        }
        growCircles();
        Collections.sort(circles);
    }

    private void growCircles() {
        for (Circle circle : circles) {
            if (circle.canGrow) {
                if (edge(circle)) {
                    circle.canGrow = false;
                } else {
                    for (Circle circle1 : circles) {
                        if (circle == circle1) {
                            continue;
                        }
                        double d = Point2D.distance(circle.x, circle.y, circle1.x, circle1.y);
                        if (d + 1 < circle.r + circle1.r) {
                            circle.canGrow = false;
                            break;
                        }
                    }
                }
            }
            if (circle.canGrow) {
                circle.r++;
            }
        }
    }

    private void addNewCircle() {
        for (int i = 0; i < 1; i++) {
            Circle newCircle = createCircle();
            if (canAdd(newCircle)) {
                circles.add(newCircle);
            }
        }
    }

    private boolean canAdd(Circle newCircle) {
        for (Circle circle : circles) {
            if (circle.x - circle.r <= newCircle.x && newCircle.x <= circle.x + circle.r && circle.y - circle.r <= newCircle.y && newCircle.y <= circle.y + circle.r) {
                return false;
            }
        }
        return true;
    }

    private Circle createCircle() {
        int x = RandomGenerator.getIntInRange(WIDTH);
        int y = RandomGenerator.getIntInRange(HEIGHT);
        return new Circle(x, y, pixmap.getPixel(x, HEIGHT - y));
    }

    private boolean edge(Circle circle) {
        return circle.x + circle.r >= WIDTH || circle.x - circle.r <= 0 || circle.y + circle.r >= HEIGHT || circle.y - circle.r <= 0;
    }

    public void popBiggestCircle(int x, int y) {
        if (circles.isEmpty()) {
            return;
        }
        y = HEIGHT - y;
        Circle biggestCircle = circles.get(circles.size() - 1);
        double distance = Point2D.distance(x, y, biggestCircle.x, biggestCircle.y);
        if (distance < biggestCircle.r) {
            circles.remove(circles.size() - 1);
        }
    }
}
