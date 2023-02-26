package com.visualg.animations.kandynsky;

import com.visualg.util.Pair;
import com.visualg.util.Serializer;
import lombok.Getter;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

class KandynskyAlg {

    private static final String kandynsky = "kandynsky";

    @Getter
    private Element selectedElement = null;

    @Getter
    private boolean selected = false;

    @Getter
    private Pair<Integer, Integer> startPosition = null;

    @Getter
    private List<Element> elements;

    public KandynskyAlg() {
        createElements();
    }


    public void createElement(int x, int y) {
        switch (KandynskySettings.settings.getShape()) {
            case CIRCLE -> {
                if (startPosition == null) {
                    startPosition = new Pair<>(x, y);
                } else {
                    elements.add(new CircleElement(startPosition.first(), startPosition.second(),
                            (int) Point2D.distance(startPosition.first(), startPosition.second(), x, y)));
                    startPosition = null;
                }
            }
            case SEMICIRCLE -> {
                if (startPosition == null) {
                    startPosition = new Pair<>(x, y);
                } else {
                    elements.add(new SemiCircleElement(startPosition.first(), startPosition.second(),
                            (int) Point2D.distance(startPosition.first(), startPosition.second(), x, y), 0));
                    startPosition = null;
                }
            }
            case QUARTER_CIRCLE -> {
                if (startPosition == null) {
                    startPosition = new Pair<>(x, y);
                } else {
                    elements.add(new QuarterCircle(startPosition.first(), startPosition.second(),
                            (int) Point2D.distance(startPosition.first(), startPosition.second(), x, y), 0));
                    startPosition = null;
                }
            }
            case LINE -> {
                if (startPosition == null) {
                    startPosition = new Pair<>(x, y);
                } else {
                    elements.add(new LineElement(startPosition.first(), startPosition.second(), x, y));
                    startPosition = null;
                }
            }
        }

    }

    public void moveElement(int x, int y) {
        if (selected) {
            move(x, y);
        } else {
            select(x, y);
        }
    }

    private void select(int x, int y) {
        selectedElement = getNearestElement(x, y);
        elements.remove(selectedElement);
        selected = true;
    }

    Element getHighlightedElement(int x, int y) {
        return getNearestElement(x, y);
    }

    private Element getNearestElement(int x, int y) {
        return elements.stream()
                .min((Element e1, Element e2) -> e1.distance(x, y) < e2.distance(x, y) ? 0 : 1)
                .orElse(null);
    }


    private void move(int x, int y) {
        selectedElement.move(x, y);
        elements.add(selectedElement);
        selected = false;
    }

    @SuppressWarnings("unchecked")
    private void createElements() {
        elements = (List<Element>) Serializer.deserialize(kandynsky);
        if (elements == null) {
            elements = new ArrayList<>();
        }
    }

    void save() {
        Serializer.serialize(elements, kandynsky);
    }

    public void clear() {
        elements.clear();
    }

    public void deleteElement() {
        elements.remove(selectedElement);
        selectedElement = null;
        selected = false;
    }

    void selectElement(int x, int y) {
        selectedElement = getNearestElement(x, y);
        selected = true;
    }

    public void unselect() {
        selected = false;
        selectedElement = null;
    }
    void rotate() {
        elements.forEach(element -> element.rotate(1));
    }
}
