package com.visualg.util.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.visualg.global.Config;

import static com.badlogic.gdx.graphics.GL20.GL_BLEND;
import static com.badlogic.gdx.graphics.GL20.GL_FUNC_ADD;
import static com.badlogic.gdx.graphics.GL20.GL_FUNC_REVERSE_SUBTRACT;
import static com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA;
import static com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA;

public enum RefreshType {
    DEFAULT(() -> {
        Color background = Config.palette.getBackground();
        Gdx.gl20.glClearColor(background.r, background.g, background.b, background.a);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glBlendEquation(GL_FUNC_ADD);
    }),
    BLEND(() -> {
        Gdx.gl20.glEnable(GL_BLEND);
        Gdx.gl20.glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
    }),
    SUBTRACT(() -> {
        Gdx.gl20.glEnable(GL_BLEND);
        Gdx.gl20.glBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl20.glBlendEquation(GL_FUNC_REVERSE_SUBTRACT);
    });

    private final Runnable refresh;

    RefreshType(Runnable animationSupplier) {
        this.refresh = animationSupplier;
    }

    public void refresh() {
        refresh.run();
    }
}
