package com.visualg.animations.fractals.multibrot;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.InteractiveSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {

    Set<InteractiveSettingsRow> rows = new HashSet<>();

    Table(MultibrotSettings multibrotSettings) {
        InteractiveSettingsRow numberOfIteration = InteractiveSettingsRow.builder()
                .label("numberOfIterations")
                .initValue(multibrotSettings::getNumberOfIteration)
                .onValueChange(newValue -> {
                    multibrotSettings.setNumberOfIteration(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(numberOfIteration);

        InteractiveSettingsRow re = InteractiveSettingsRow.builder()
                .label("re")
                .initValue(() -> multibrotSettings.getMultibrotPower().re())
                .onValueChange(newValue -> {
                    multibrotSettings.setMultibrotPower(multibrotSettings.getMultibrotPower().withRe(parseDouble(newValue)));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(re);

        InteractiveSettingsRow im = InteractiveSettingsRow.builder()
                .label("im")
                .initValue(() -> multibrotSettings.getMultibrotPower().im())
                .onValueChange(newValue -> {
                    multibrotSettings.setMultibrotPower(multibrotSettings.getMultibrotPower().withIm(parseDouble(newValue)));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(im);

        InteractiveSettingsRow r = InteractiveSettingsRow.builder()
                .label("r")
                .initValue(multibrotSettings::getRMultiplier)
                .onValueChange(newValue -> {
                    multibrotSettings.setRMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(r);

        InteractiveSettingsRow g = InteractiveSettingsRow.builder()
                .label("g")
                .initValue(multibrotSettings::getGMultiplier)
                .onValueChange(newValue -> {
                    multibrotSettings.setGMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(g);

        InteractiveSettingsRow b = InteractiveSettingsRow.builder()
                .label("b")
                .initValue(multibrotSettings::getBMultiplier)
                .onValueChange(newValue -> {
                    multibrotSettings.setBMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(b);

        InteractiveSettingsRow moveDelta = InteractiveSettingsRow.builder()
                .label("moveDelta")
                .initValue(multibrotSettings::getMoveDelta)
                .onValueChange(newValue -> {
                    multibrotSettings.setMoveDelta(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(moveDelta);

        InteractiveSettingsRow xOffset = InteractiveSettingsRow.builder()
                .label("xOffset")
                .initValue(multibrotSettings::getXOffset)
                .onValueChange(newValue -> {
                    multibrotSettings.setXOffset(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(xOffset);

        InteractiveSettingsRow yOffset = InteractiveSettingsRow.builder()
                .label("yOffset")
                .initValue(multibrotSettings::getYOffset)
                .onValueChange(newValue -> {
                    multibrotSettings.setYOffset(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(yOffset);

        InteractiveSettingsRow zoom = InteractiveSettingsRow.builder()
                .label("zoom")
                .initValue(multibrotSettings::getZoom)
                .onValueChange(newValue -> {
                    multibrotSettings.setZoom(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(zoom);

        InteractiveSettingsRow zoomMultiplier = InteractiveSettingsRow.builder()
                .label("zoomMultiplier")
                .initValue(multibrotSettings::getZoomMultiplier)
                .onValueChange(newValue -> {
                    multibrotSettings.setZoomMultiplier(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(zoomMultiplier);
    }

    void updateFields() {
        rows.forEach(InteractiveSettingsRow::updateTextField);
    }

    private void addSettingsRow(InteractiveSettingsRow interactiveSettingsRow) {
        addRow(interactiveSettingsRow.getDefaultSettingsRow());
        rows.add(interactiveSettingsRow);
    }
}
