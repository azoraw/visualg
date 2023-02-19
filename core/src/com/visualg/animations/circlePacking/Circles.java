package com.visualg.animations.circlePacking;

import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.util.RandomDecorator;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

class Circles {
    int HOW_MANY_CIRCLES = 3;

    private final ArrayList<Circle> circles = new ArrayList<>();
    private final Pixmap pixmap;

    Circles(Pixmap pixmapResized) {
        this.pixmap = pixmapResized;
        circles.add(createCircle());
    }

    ArrayList<Circle> getCircles() {
        return circles;
    }

    void update() {

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
        int x = RandomDecorator.Random.nextInt(WIDTH);
        int y = RandomDecorator.Random.nextInt(HEIGHT);
        return new Circle(x, y, pixmap.getPixel(x, HEIGHT - y));
    }

    private boolean edge(Circle circle) {
        return circle.x + circle.r >= WIDTH || circle.x - circle.r <= 0 || circle.y + circle.r >= HEIGHT || circle.y - circle.r <= 0;
    }

    void popBiggestCircle(int x, int y) {
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
