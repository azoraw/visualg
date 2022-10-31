package com.visualg.animations.colorPicker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.visualg.ui.pixmap.PixmapFactory;
import com.visualg.util.Pair;
import com.visualg.util.color.ColorGenerator;
import lombok.Getter;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

class ColorPickerAlg {

    private final int CIRCLE_RADIUS = (HEIGHT / 2) - 1;
    private final int RING_WIDTH = 50;
    private final int INNER_CIRCLE_RADIUS = CIRCLE_RADIUS - RING_WIDTH;
    private final int xMid = WIDTH / 2;
    private final int yMid = HEIGHT / 2;
    private final int space = 10;
    private final int p1X = xMid + INNER_CIRCLE_RADIUS - space;
    private final int p1Y = yMid;
    private final int p2X = (xMid - INNER_CIRCLE_RADIUS / 2) + space;
    private final int p2Y = (int) (yMid + INNER_CIRCLE_RADIUS * Math.sqrt(3) / 2) - space;
    private final int p3X = (xMid - INNER_CIRCLE_RADIUS / 2) + space;
    private final int p3Y = (int) (yMid - INNER_CIRCLE_RADIUS * Math.sqrt(3) / 2) + space;

    @Getter
    private Pair<Integer, Integer> huePosition = new Pair<>(xMid + INNER_CIRCLE_RADIUS + RING_WIDTH / 2, yMid);
    @Getter
    private Pair<Integer, Integer> valueAndSaturationPosition = new Pair<>(xMid, yMid);

    @Getter
    private final Pixmap pixmap;

    ColorPickerAlg() {
        pixmap = PixmapFactory.create();
        updatePixmap();
        updateChosenColor();
    }

    private void updatePixmap() {
        for (int x = xMid - CIRCLE_RADIUS - 1; x < xMid + CIRCLE_RADIUS + 1; x++) {
            for (int y = yMid - CIRCLE_RADIUS - 1; y < yMid + CIRCLE_RADIUS + 1; y++) {
                drawPickedColor(x, y);
                drawHuePicker(x, y);
                drawTrianglePicker(x, y);
            }
        }
    }

    private void drawPickedColor(int x, int y) {
        if (!insideHuePickerRing(x, y)) {
            pixmap.drawPixel(x, y, Color.rgba8888(Settings.INSTANCE.getChosenColor()));
        }
    }

    private void drawTrianglePicker(int x, int y) {
        boolean isInsideTriangle = isInsideTriangle(x, y);
        if (isInsideTriangle) {
            double hue = getAngle(huePosition.first(), huePosition.second());
            double saturation = 1 - normalize(x, p2X, p1X);
            double value = 1 - normalize(y, p3Y, p2Y);
            pixmap.drawPixel(x, y, Color.rgba8888(ColorGenerator.fromHSV((float) hue, (float) saturation, (float) value)));
        }
    }

    double normalize(double value, double min, double max) {
        return 1 - ((value - min) / (max - min));
    }

    private boolean isInsideTriangle(int x, int y) {
        int vxUp = p2X - p1X;
        int vyUp = p2Y - p1Y;
        int vxDown = vxUp;
        int vyDown = p3Y - p1Y;
        int vx2Up = p2X - x;
        int vy2Up = p2Y - y;
        int vx2Down = p3X - x;
        int vy2Down = p3Y - y;
        int crossProductUp = vxUp * vy2Up - vyUp * vx2Up;
        int crossProductDown = vxDown * vy2Down - vyDown * vx2Down;
        return crossProductUp < 0 && crossProductDown > 0 && x > p2X;
    }

    private void drawHuePicker(int x, int y) {
        if (insideHuePickerRing(x, y)) {
            double angle = getAngle(x, y);
            pixmap.drawPixel(x, y, Color.rgba8888(ColorGenerator.fromHSV((float) angle, 1, 1)));
        }
    }

    private double getAngle(int x, int y) {
        var xNorm = x - xMid;
        var yNorm = y - yMid;
        var rad = Math.atan2(xNorm, yNorm);
        return rad * (180 / Math.PI);
    }

    private boolean insideHuePickerRing(int x, int y) {
        double pythagoras = pow(abs(x - xMid), 2) + pow(abs(y - yMid), 2);
        return pythagoras < pow(CIRCLE_RADIUS, 2) && pythagoras > pow(INNER_CIRCLE_RADIUS, 2);
    }

    public void touch(int x, int y) {
        if (isInsideTriangle(x, y)) {
            updateValueAndSaturation(x, y);
            updateChosenColor();
            updatePixmap();
        }
        if (insideHuePickerRing(x, y)) {
            updateHue(x, y);
            updateChosenColor();
            updatePixmap();
        }
    }

    private void updateHue(int x, int y) {
        huePosition = new Pair<>(x, y);
    }

    private void updateValueAndSaturation(int x, int y) {
        valueAndSaturationPosition = new Pair<>(x, y);
    }

    private void updateChosenColor() {
        double hue = getAngle(huePosition.first(), huePosition.second());
        double saturation = 1 - normalize(valueAndSaturationPosition.first(), p2X, p1X);
        double value = 1 - normalize(valueAndSaturationPosition.second(), p3Y, p2Y);
        Settings.INSTANCE.setChosenColor(ColorGenerator.fromHSV((float) hue, (float) saturation, (float) value));
    }
}
