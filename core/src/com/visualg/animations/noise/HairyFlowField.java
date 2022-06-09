package com.visualg.animations.noise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.noise.flow.HairyFlowFieldAlg;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.RefreshType.BLEND;

public class HairyFlowField extends Actor {

    private ShapeRenderer sr;
    private HairyFlowFieldAlg alg;
    private Color color = new Color(1, 1, 1, 0.01f);
    private FrameBuffer fbo = new FrameBuffer(Pixmap.Format.RGBA8888, WIDTH, HEIGHT, false);

    public HairyFlowField() {
        sr = new ShapeRenderer();
        sr.setColor(color);
        alg = new HairyFlowFieldAlg();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        fbo.begin();
        BLEND.refresh();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        alg.getDots().forEach(dot ->
                sr.circle(dot.getX(), dot.getY(), 1)
        );
        sr.end();
        fbo.end();

        batch.begin();
        batch.draw(fbo.getColorBufferTexture(), 0, 0, WIDTH, HEIGHT, 0, 0, 1, 1);
        alg.update();

    }

}
