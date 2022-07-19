package com.visualg.util.libgdx.ui;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.String.valueOf;

//for 2 way biding
public class InteractiveSettingsRow {

    @Getter
    private final DefaultSettingsRow defaultSettingsRow;
    private final Supplier<Object> initValueSupplier;

    @Builder
    public InteractiveSettingsRow(String label, Supplier<Object> initValue, Consumer<String> onValueChange, Consumer<String> afterValueChange) {
        defaultSettingsRow = DefaultSettingsRow.builder()
                .label(label)
                .initValue(initValue.get())
                .onValueChange(onValueChange)
                .afterValueChange(afterValueChange)
                .build();
        this.initValueSupplier = initValue;
    }

    public void updateTextField() {
        defaultSettingsRow.updateText(valueOf(initValueSupplier.get()));
    }
}
