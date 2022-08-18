package com.visualg.animations.circlePacking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.visualg.ui.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class CirclePacking extends ShapeRendererActor {

    private final Circles circles;

    public CirclePacking() {
        super(Filled);
        Pixmap pixmap200 = new Pixmap(Gdx.files.internal("RandomPicture.JPG"));
        Pixmap pixmap100 = new Pixmap(WIDTH, HEIGHT, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight());
        circles = new Circles(pixmap100);
    }

    @Override
    protected void drawFrame() {
        for (int i = 0; i < circles.getCircles().size(); i++) {
            Circle circle = circles.getCircles().get(i);
            sr.setColor(circle.color);
            sr.circle(circle.x, circle.y, (float) circle.r);
        }

        sr.end();
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.RED);
        Circle circle = circles.getCircles().get(circles.getCircles().size() - 1);
        sr.circle(circle.x, circle.y, (float) circle.r);
        circles.popBiggestCircle(Gdx.input.getX(), Gdx.input.getY());
        circles.update();
    }
}
