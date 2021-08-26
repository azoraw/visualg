package com.visualg.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public enum RefreshType {
    DEFAULT(() -> {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }),
    BLEND(() -> {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    });

    private final Runnable refresh;

    RefreshType(Runnable animationSupplier) {
        this.refresh = animationSupplier;
    }

    public void refresh() {
        refresh.run();
    }
}
