package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.controls.fileio.ScreenShotSaver;
import com.visualg.global.Config;

import static com.visualg.animations.noise.transparent.TransparentSettings.settings;
import static com.visualg.global.Config.palette;
import static com.visualg.global.Config.updatesPerFrame;

public class HairyFlowFieldPixmapActor extends Actor {

    private final HairyFlowFieldAlg alg;
    private final Pixmap pixmap;
    private final Texture texture;
    private boolean canUpdate = true;
    private final int monitorWidth;
    private final int monitorHeight;

    public HairyFlowFieldPixmapActor() {
        pixmap = new Pixmap(Config.WIDTH, Config.HEIGHT, Pixmap.Format.RGBA8888);

        pixmap.setColor(palette.getBackground());
        pixmap.fill();
        texture = new Texture(pixmap);

        alg = new HairyFlowFieldAlg(settings);

        for (int i = 0; i < settings.getInitFrameSkips(); i++) {
            renderFrame();
        }
        monitorWidth = Gdx.graphics.getWidth();
        monitorHeight = Gdx.graphics.getHeight();
    }

    public void renderFrame() {
        alg.getDots().forEach(this::drawDot);
        alg.update();
    }

    private void drawDot(Dot dot) {
        int x = dot.getX();
        int y = dot.getY();

        Color c = dot.getColor();
        blendPixel(x, y, c);
    }

    private void blendPixel(int x, int y, Color src) {
        int dstRGBA = pixmap.getPixel(x, y);

        float Rd = ((dstRGBA >>> 24) & 0xff) / 255f;
        float Gd = ((dstRGBA >>> 16) & 0xff) / 255f;
        float Bd = ((dstRGBA >>> 8) & 0xff) / 255f;
        float Ad = (dstRGBA & 0xff) / 255f;

        float Rs = src.r;
        float Gs = src.g;
        float Bs = src.b;
        float As = src.a;

        // RGB: standard src-over
        float Rout = Rs * As + Rd * (1f - As);
        float Gout = Gs * As + Gd * (1f - As);
        float Bout = Bs * As + Bd * (1f - As);

        // Alpha: additive like GL_ONE
        float Aout = As + Ad * (1f - As);
        if (Aout > 1f) Aout = 1f;

        pixmap.drawPixel(
                x, y,
                Color.rgba8888(Rout, Gout, Bout, Aout)
        );
    }

    /* ==========================================================
       Lifecycle
       ========================================================== */

    @Override
    public void act(float delta) {
        super.act(delta);
        if (!canUpdate) return;
        for (int i = 0; i < updatesPerFrame; i++) {
            renderFrame();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        texture.draw(pixmap, 0, 0);


        batch.setColor(getColor().cpy().mul(parentAlpha));
        batch.draw(texture, getX(), getY(), monitorWidth, monitorHeight);
    }

    @Override
    public boolean remove() {
        dispose();
        super.remove();
        return false;
    }

    public void dispose() {
        if (texture != null) texture.dispose();
        pixmap.dispose();
    }

    public Runnable onScreenShot() {
        return () -> {
            canUpdate = false;
            ScreenShotSaver.take(pixmap);
            canUpdate = true;
        };
    }
}
