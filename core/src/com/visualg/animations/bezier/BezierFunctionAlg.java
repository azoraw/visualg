package com.visualg.animations.bezier;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.visualg.global.Config;
import com.visualg.util.Pair;
import com.visualg.util.color.ColorGenerator;

import java.util.HashSet;
import java.util.Set;

import static com.visualg.animations.bezier.BezierSettings.settings;
import static com.visualg.util.color.ColorGenerator.fromHSV;

class BezierFunctionAlg {
    private final int index;
    private final Color randomColor1;
    private final Color randomColor2;

    public BezierFunctionAlg(int index) {
        this.index = index;
        randomColor1 = new Color(ColorGenerator.getRandomColor());
        randomColor1.a = settings.getBlobSetting(index).getTransparency();
        randomColor2 = new Color(ColorGenerator.getRandomColor());
        randomColor2.a = settings.getBlobSetting(index).getTransparency2();
    }

    Set<Line> getQuadraticBezier(Vector2 position1, Vector2 position2, Vector2 position3, Vector2 position4, int delta) {
        HashSet<Line> lines = new HashSet<>();

        for (int i = 0; i <= delta; i++) {
            Vector2 lerp1 = position1.cpy().lerp(position2, (float) i / delta);
            Vector2 lerp2 = position2.cpy().lerp(position3, (float) i / delta);
            Vector2 lerp3 = position3.cpy().lerp(position4, (float) i / delta);
            Vector2 lerp4 = position4.cpy().lerp(position1, (float) i / delta);

            lines.add(new Line(lerp1, lerp2, getColorGradient(lerp1, lerp2)));
            lines.add(new Line(lerp2, lerp3, getColorGradient(lerp2, lerp3)));
            lines.add(new Line(lerp3, lerp4, getColorGradient(lerp3, lerp4)));
            lines.add(new Line(lerp4, lerp1, getColorGradient(lerp4, lerp1)));
        }
        return lines;
    }

    private Pair<Color, Color> getColorGradient(Vector2 pos1, Vector2 pos2) {
        final BlobSetting blobSetting = settings.getBlobSetting(index);
        Color first;
        Color second;
        switch (blobSetting.getBlobColor()) {
            case PRIMARY -> {
                final Color color = Config.palette.getPrimaryColor().cpy();
                color.a = settings.getBlobSetting(index).getTransparency();
                first = color;
            }
            case BACKGROUND -> {
                final Color color = Config.palette.getBackground().cpy();
                color.a = settings.getBlobSetting(index).getTransparency();
                first = color;
            }
            case RANDOM -> first = randomColor1;
            case POSITION_BASED ->
                    first = fromHSV(getAngle(pos1.x, pos1.y), 1, 1, settings.getBlobSetting(index).getTransparency());
            default -> throw new IllegalStateException("Unexpected value: " + blobSetting.getBlobColor());
        }
        if (!blobSetting.isGradient()) {
            return new Pair<>(first, first);
        }
        switch (blobSetting.getBlobColor2()) {
            case PRIMARY -> {
                final Color color = Config.palette.getPrimaryColor().cpy();
                color.a = settings.getBlobSetting(index).getTransparency2();
                second = color;
            }
            case BACKGROUND -> {
                final Color color = Config.palette.getBackground().cpy();
                color.a = settings.getBlobSetting(index).getTransparency2();
                second = color;
            }
            case RANDOM -> second = randomColor2;
            case POSITION_BASED ->
                    second = fromHSV(getAngle(pos2.x, pos2.y), 1, 1, settings.getBlobSetting(index).getTransparency2());
            default -> throw new IllegalStateException("Unexpected value: " + blobSetting.getBlobColor());
        }
        return new Pair<>(first, second);
    }

    private float getAngle(float x, float y) {
        var xNorm = x - Config.WIDTH / 2;
        var yNorm = y - Config.HEIGHT / 2;
        var rad = Math.atan2(xNorm, yNorm);
        return (float) (rad * (180 / Math.PI));
    }
}
