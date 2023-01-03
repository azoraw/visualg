package com.visualg.animations.kandynsky;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.global.Config;
import com.visualg.ui.ShapeRendererExtended;
import com.visualg.util.Mouse;
import com.visualg.util.Pair;

import java.awt.geom.Point2D;
import java.io.File;
import java.util.List;

import static com.visualg.animations.kandynsky.EditMode.MOVE;
import static com.visualg.animations.kandynsky.EditMode.SELECT;

class KandynskyActor extends Actor {
    private static final String BACKGROUND_PATH = "kandynsky" + File.separator + "Kandinsky.jpg";

    private final KandynskyAlg alg;
    private final ShapeRendererExtended sr;
    private final Texture backgroundTexture;

    protected KandynskyActor(KandynskyAlg kandynskyAlg) {
        sr = new ShapeRendererExtended();
        alg = kandynskyAlg;
        backgroundTexture = new Texture(BACKGROUND_PATH);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawBackground(batch);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        drawAllElements();
        drawMovingSelectedElement();
        drawSelectedElement();
        drawCreateElement();
        highlightNearestElement();
        sr.end();
        batch.begin();

        update();
    }

    private void drawBackground(Batch batch) {
        if (Settings.INSTANCE.isDrawBackground()) {
            batch.draw(backgroundTexture, 0, 0, Config.WIDTH, Config.HEIGHT);
        }
    }

    private void update() {
        if(Settings.INSTANCE.isRotate()) {
            for (int i = 0; i < Config.updatesPerFrame; i++) {
                alg.rotate();
            }
        }
    }

    private void drawSelectedElement() {
        sr.setColor(Color.GREEN);
        if (alg.getSelectedElement() != null && Settings.INSTANCE.getEditMode() == SELECT) {
            drawElement(alg.getSelectedElement());
        }
    }

    private void drawCreateElement() {
        final Pair<Integer, Integer> startPosition = alg.getStartPosition();
        if (startPosition != null) {
            switch (Settings.INSTANCE.getShape()) {
                case CIRCLE -> {
                    final double distance = Point2D.distance(startPosition.first(), startPosition.second(), Mouse.getX(), Mouse.getY());
                    sr.circle(startPosition.first(), startPosition.second(), (int) distance);
                }
                case SEMICIRCLE -> {
                    final double distance = Point2D.distance(startPosition.first(), startPosition.second(), Mouse.getX(), Mouse.getY());
                    sr.arc2(startPosition.first(), startPosition.second(), (int) distance, 0, 180);
                }
                case QUARTER_CIRCLE -> {
                    final double distance = Point2D.distance(startPosition.first(), startPosition.second(), Mouse.getX(), Mouse.getY());
                    sr.arc2(startPosition.first(), startPosition.second(), (int) distance, 0, 90);
                }
                case LINE -> sr.line(startPosition.first(), startPosition.second(), Mouse.getX(), Mouse.getY());
            }
        }
    }

    private void drawMovingSelectedElement() {
        boolean isSelected = alg.isSelected();
        if (isSelected && Settings.INSTANCE.getEditMode() == MOVE) {
            final Element selectedElement = alg.getSelectedElement();
            sr.setColor(Color.GREEN);
            if (selectedElement instanceof CircleElement circleElement) {
                sr.circle(Mouse.getX(), Mouse.getY(), circleElement.getRadius());
            }
            if (selectedElement instanceof SemiCircleElement semiCircleElement) {
                sr.arc2(Mouse.getX(), Mouse.getY(), semiCircleElement.getRadius(), semiCircleElement.getRotation(), 180);
            }
            if (selectedElement instanceof QuarterCircle quarterCircle) {
                sr.arc2(Mouse.getX(), Mouse.getY(), quarterCircle.getRadius(), quarterCircle.getRotation(), 90);
            }
            if (selectedElement instanceof LineElement line) {
                final int x = Mouse.getX();
                final int y = Mouse.getY();
                final Pair<Float, Float> center = line.getCenter();
                float xDelta = x - center.first();
                float yDelta = y - center.second();
                float xStart = xDelta + line.getXStart();
                float yStart = yDelta + line.getYStart();
                float xEnd = xDelta + line.getXEnd();
                float yEnd = yDelta + line.getYEnd();
                sr.line(xStart, yStart, xEnd, yEnd);
            }

        }
    }

    private void drawAllElements() {
        sr.setColor(Color.WHITE);
        final List<Element> elements = alg.getElements();
        for (Element element : elements) {
            drawElement(element);
        }
    }

    private void drawElement(Element element) {
        if (element instanceof CircleElement circle) {
            sr.circle(circle.getX(), circle.getY(), circle.getRadius());
        }
        if (element instanceof LineElement line) {
            sr.line(line.getXStart(), line.getYStart(), line.getXEnd(), line.getYEnd());
        }
        if (element instanceof SemiCircleElement semiCircle) {
            sr.arc2(semiCircle.getX(), semiCircle.getY(), semiCircle.getRadius(), semiCircle.getRotation(), 180);
        }
        if (element instanceof QuarterCircle quarterCircle) {
            sr.arc2(quarterCircle.getX(), quarterCircle.getY(), quarterCircle.getRadius(), quarterCircle.getRotation(), 90);
        }
    }

    private void highlightNearestElement() {
        if (MOVE == Settings.INSTANCE.getEditMode() && !alg.isSelected()) {
            sr.setColor(Color.YELLOW);
            final Element highlightedElement = alg.getHighlightedElement(Mouse.getX(), Mouse.getY());
            if (highlightedElement instanceof CircleElement circle) {
                sr.circle(circle.getX(), circle.getY(), circle.getRadius());
            }
            if (highlightedElement instanceof SemiCircleElement circle) {
                sr.arc2(circle.getX(), circle.getY(), circle.getRadius(), circle.getRotation(), 180);
            }
            if (highlightedElement instanceof QuarterCircle circle) {
                sr.arc2(circle.getX(), circle.getY(), circle.getRadius(), circle.getRotation(), 90);
            }
            if (highlightedElement instanceof LineElement line) {
                sr.line(line.getXStart(), line.getYStart(), line.getXEnd(), line.getYEnd());
            }
        }
    }
}
