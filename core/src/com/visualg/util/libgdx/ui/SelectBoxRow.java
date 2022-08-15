package com.visualg.util.libgdx.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultLabel;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultSelectBox;
import lombok.Builder;

import java.util.function.Consumer;

public class SelectBoxRow<T> extends SettingsRow {

    private final Label label;
    private final DefaultSelectBox<T> selectBox;

    @Builder
    public SelectBoxRow(String label, Consumer<T> onChange, T selected, T[] items) {
        this.label = new DefaultLabel(label);
        this.selectBox =  DefaultSelectBox.<T>builder()
                .onChange(onChange)
                .selected(selected)
                .items(items)
                .build();
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public Widget getWidget() {
        return selectBox;
    }
}
