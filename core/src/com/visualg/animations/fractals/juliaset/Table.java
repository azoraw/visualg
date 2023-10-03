package com.visualg.animations.fractals.juliaset;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.InteractiveSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {

    Set<InteractiveSettingsRow> rows = new HashSet<>();

    Table(JuliaSetSettings juliaSetSettings) {
        InteractiveSettingsRow numberOfIteration = InteractiveSettingsRow.builder()
                .label("numberOfIterations")
                .initValue(juliaSetSettings::getNumberOfIteration)
                .onValueChange(newValue -> {
                    juliaSetSettings.setNumberOfIteration(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(numberOfIteration);

        InteractiveSettingsRow re = InteractiveSettingsRow.builder()
                .label("re")
                .initValue(() -> juliaSetSettings.getComplexNumber().re())
                .onValueChange(newValue -> {
                    juliaSetSettings.setComplexNumber(juliaSetSettings.getComplexNumber().withRe(parseDouble(newValue)));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(re);

        InteractiveSettingsRow im = InteractiveSettingsRow.builder()
                .label("im")
                .initValue(() -> juliaSetSettings.getComplexNumber().im())
                .onValueChange(newValue -> {
                    juliaSetSettings.setComplexNumber(juliaSetSettings.getComplexNumber().withIm(parseDouble(newValue)));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(im);

        InteractiveSettingsRow r = InteractiveSettingsRow.builder()
                .label("r")
                .initValue(juliaSetSettings::getRMultiplier)
                .onValueChange(newValue -> {
                    juliaSetSettings.setRMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(r);

        InteractiveSettingsRow g = InteractiveSettingsRow.builder()
                .label("g")
                .initValue(juliaSetSettings::getGMultiplier)
                .onValueChange(newValue -> {
                    juliaSetSettings.setGMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(g);

        InteractiveSettingsRow b = InteractiveSettingsRow.builder()
                .label("b")
                .initValue(juliaSetSettings::getBMultiplier)
                .onValueChange(newValue -> {
                    juliaSetSettings.setBMultiplier(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(b);

        InteractiveSettingsRow moveDelta = InteractiveSettingsRow.builder()
                .label("moveDelta")
                .initValue(juliaSetSettings::getMoveDelta)
                .onValueChange(newValue -> {
                    juliaSetSettings.setMoveDelta(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(moveDelta);

        InteractiveSettingsRow xOffset = InteractiveSettingsRow.builder()
                .label("xOffset")
                .initValue(juliaSetSettings::getXOffset)
                .onValueChange(newValue -> {
                    juliaSetSettings.setXOffset(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(xOffset);

        InteractiveSettingsRow yOffset = InteractiveSettingsRow.builder()
                .label("yOffset")
                .initValue(juliaSetSettings::getYOffset)
                .onValueChange(newValue -> {
                    juliaSetSettings.setYOffset(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(yOffset);

        InteractiveSettingsRow zoom = InteractiveSettingsRow.builder()
                .label("zoom")
                .initValue(juliaSetSettings::getZoom)
                .onValueChange(newValue -> {
                    juliaSetSettings.setZoom(parseDouble(newValue));
                    fire(new RestartEvent());
                })
                .build();
        addSettingsRow(zoom);

        InteractiveSettingsRow zoomMultiplier = InteractiveSettingsRow.builder()
                .label("zoomMultiplier")
                .initValue(juliaSetSettings::getZoomMultiplier)
                .onValueChange(newValue -> {
                    juliaSetSettings.setZoomMultiplier(parseDouble(newValue));
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
