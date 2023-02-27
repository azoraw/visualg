package com.visualg.animations.fractals.mandelbrot;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.InteractiveSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {

    Set<InteractiveSettingsRow> rows = new HashSet<>();

    Table(MandelbrotSettings mandelbrotSettings) {
        InteractiveSettingsRow numberOfIteration = InteractiveSettingsRow.builder()
                .label("numberOfIterations")
                .initValue(mandelbrotSettings::getNumberOfIteration)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setNumberOfIteration(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(numberOfIteration);

        InteractiveSettingsRow r = InteractiveSettingsRow.builder()
                .label("r")
                .initValue(mandelbrotSettings::getRMultiplier)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setRMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(r);

        InteractiveSettingsRow g = InteractiveSettingsRow.builder()
                .label("g")
                .initValue(mandelbrotSettings::getGMultiplier)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setGMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(g);

        InteractiveSettingsRow b = InteractiveSettingsRow.builder()
                .label("b")
                .initValue(mandelbrotSettings::getBMultiplier)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setBMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(b);

        InteractiveSettingsRow moveDelta = InteractiveSettingsRow.builder()
                .label("moveDelta")
                .initValue(mandelbrotSettings::getMoveDelta)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setMoveDelta(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(moveDelta);

        InteractiveSettingsRow xOffset = InteractiveSettingsRow.builder()
                .label("xOffset")
                .initValue(mandelbrotSettings::getXOffset)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setXOffset(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(xOffset);

        InteractiveSettingsRow yOffset = InteractiveSettingsRow.builder()
                .label("yOffset")
                .initValue(mandelbrotSettings::getYOffset)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setYOffset(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(yOffset);

        InteractiveSettingsRow zoom = InteractiveSettingsRow.builder()
                .label("zoom")
                .initValue(mandelbrotSettings::getZoom)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setZoom(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(zoom);

        InteractiveSettingsRow zoomMultiplier = InteractiveSettingsRow.builder()
                .label("zoomMultiplier")
                .initValue(mandelbrotSettings::getZoomMultiplier)
                .onValueChange(newValue -> {
                    mandelbrotSettings.setZoomMultiplier(parseDouble(newValue));
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
