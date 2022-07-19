package com.visualg.animations.fractals.juliaset;

import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.InteractiveSettingsRow;
import com.visualg.util.libgdx.ui.SettingsTable;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class SettingsView extends SettingsTable {

    Set<InteractiveSettingsRow> rows = new HashSet<>();

    public SettingsView(Settings settings) {
        InteractiveSettingsRow numberOfIteration = InteractiveSettingsRow.builder()
                .label("numberOfIterations")
                .initValue(settings::getNumberOfIteration)
                .onValueChange(newValue -> settings.setNumberOfIteration(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(numberOfIteration);

        InteractiveSettingsRow re = InteractiveSettingsRow.builder()
                .label("re")
                .initValue(() -> settings.getComplexNumber().getRe())
                .onValueChange(newValue -> settings.getComplexNumber().setRe(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(re);

        InteractiveSettingsRow im = InteractiveSettingsRow.builder()
                .label("im")
                .initValue(() -> settings.getComplexNumber().getIm())
                .onValueChange(newValue -> settings.getComplexNumber().setIm(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(im);

        InteractiveSettingsRow r = InteractiveSettingsRow.builder()
                .label("r")
                .initValue(settings::getRMultiplier)
                .onValueChange(newValue -> settings.setRMultiplier(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(r);

        InteractiveSettingsRow g = InteractiveSettingsRow.builder()
                .label("g")
                .initValue(settings::getGMultiplier)
                .onValueChange(newValue -> settings.setGMultiplier(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(g);

        InteractiveSettingsRow b = InteractiveSettingsRow.builder()
                .label("b")
                .initValue(settings::getBMultiplier)
                .onValueChange(newValue -> settings.setBMultiplier(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(b);

        InteractiveSettingsRow moveDelta = InteractiveSettingsRow.builder()
                .label("moveDelta")
                .initValue(settings::getMoveDelta)
                .onValueChange(newValue -> settings.setMoveDelta(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(moveDelta);

        InteractiveSettingsRow xOffset = InteractiveSettingsRow.builder()
                .label("xOffset")
                .initValue(settings::getXOffset)
                .onValueChange(newValue -> settings.setXOffset(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(xOffset);

        InteractiveSettingsRow yOffset = InteractiveSettingsRow.builder()
                .label("Offset")
                .initValue(settings::getYOffset)
                .onValueChange(newValue -> settings.setYOffset(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(yOffset);

        InteractiveSettingsRow zoom = InteractiveSettingsRow.builder()
                .label("zoom")
                .initValue(settings::getZoom)
                .onValueChange(newValue -> settings.setZoom(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addSettingsRow(zoom);

        InteractiveSettingsRow zoomMultiplier = InteractiveSettingsRow.builder()
                .label("zoomMultiplier")
                .initValue(settings::getZoomMultiplier)
                .onValueChange(newValue -> settings.setZoomMultiplier(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
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
