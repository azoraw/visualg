package com.visualg.util.libgdx.ui.simplifiedComponents;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.visualg.global.Config;
import lombok.Builder;

import java.util.function.Consumer;

public class DefaultSelectBox<T> extends SelectBox<T> {

    @Builder
    public DefaultSelectBox(Consumer<T> onChange, T selected, T[] items) {
        super(Config.skin);
        setItems(items);
        setSelected(selected);
        addListener(new ChangeListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                T selected = ((SelectBox<T>) actor).getSelected();
                onChange.accept(selected);
            }
        });
    }
}
