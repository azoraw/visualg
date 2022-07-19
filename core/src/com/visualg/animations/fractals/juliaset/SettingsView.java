package com.visualg.animations.fractals.juliaset;

import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.SettingsTable;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class SettingsView extends SettingsTable {

    public SettingsView(Settings settings) {
        DefaultSettingsRow numberOfIteration = DefaultSettingsRow.builder()
                .label("numberOfIterations")
                .initValue(settings.getNumberOfIteration())
                .onValueChange(newValue -> settings.setNumberOfIteration(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(numberOfIteration);


        DefaultSettingsRow re = DefaultSettingsRow.builder()
                .label("re")
                .initValue(settings.getComplexNumber().getRe())
                .onValueChange(newValue -> settings.getComplexNumber().setRe(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(re);

        DefaultSettingsRow im = DefaultSettingsRow.builder()
                .label("im")
                .initValue(settings.getComplexNumber().getIm())
                .onValueChange(newValue -> settings.getComplexNumber().setIm(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(im);
        DefaultSettingsRow r = DefaultSettingsRow.builder()
                .label("r")
                .initValue(settings.getRMultiplier())
                .onValueChange(newValue -> settings.setRMultiplier(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(r);

        DefaultSettingsRow g = DefaultSettingsRow.builder()
                .label("g")
                .initValue(settings.getGMultiplier())
                .onValueChange(newValue -> settings.setGMultiplier(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(g);

        DefaultSettingsRow b = DefaultSettingsRow.builder()
                .label("b")
                .initValue(settings.getBMultiplier())
                .onValueChange(newValue -> settings.setBMultiplier(parseInt(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(b);

        DefaultSettingsRow moveDelta = DefaultSettingsRow.builder()
                .label("moveDelta")
                .initValue(settings.getMoveDelta())
                .onValueChange(newValue -> settings.setMoveDelta(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(moveDelta);

        DefaultSettingsRow xOffset = DefaultSettingsRow.builder()
                .label("xOffset")
                .initValue(settings.getXOffset())
                .onValueChange(newValue -> settings.setXOffset(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(xOffset);

        DefaultSettingsRow yOffset = DefaultSettingsRow.builder()
                .label("Offset")
                .initValue(settings.getYOffset())
                .onValueChange(newValue -> settings.setYOffset(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(yOffset);

        DefaultSettingsRow zoom = DefaultSettingsRow.builder()
                .label("zoom")
                .initValue(settings.getZoom())
                .onValueChange(newValue -> settings.setZoom(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(zoom);
        DefaultSettingsRow zoomMultiplier = DefaultSettingsRow.builder()
                .label("zoomMultiplier")
                .initValue(settings.getZoomMultiplier())
                .onValueChange(newValue -> settings.setZoomMultiplier(parseDouble(newValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();
        addRow(zoomMultiplier);
    }
}
