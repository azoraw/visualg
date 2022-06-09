package com.visualg.animations.noise.flow;

import com.visualg.util.libgdx.ShapeRendererActor;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class FlowFieldActor extends ShapeRendererActor {

    private final FlowFieldAlg alg;

    public FlowFieldActor() {
        super(Line);
        alg = new FlowFieldAlg();
    }

    @Override
    protected void drawFrame() {
        for (int x = 0; x < WIDTH / alg.scale; x++) {
            for (int y = 0; y < HEIGHT / alg.scale; y++) {
                sr.line(x * (int) alg.scale, y * (int) alg.scale, alg.getXCoordinate(x, y), alg.getYCoordinate(x, y));
            }
        }
        alg.update();
    }
}
