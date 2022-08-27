package com.visualg.util.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.visualg.global.Config;

public enum RefreshType {
    DEFAULT(() -> {
        Color background = Config.palette.getBackground();
        Gdx.gl.glClearColor(background.r, background.g, background.b, background.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }),
    BLEND(() -> {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl20.glBlendFuncSeparate(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA);
    });

    private final Runnable refresh;

    RefreshType(Runnable animationSupplier) {
        this.refresh = animationSupplier;
    }

    public void refresh() {
        refresh.run();
    }
}
