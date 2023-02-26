package com.visualg.animations.kandynsky;

import com.visualg.ui.settings.InteractiveSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

class Table extends SettingsTable {

    private final List<InteractiveSettingsRow> selectedElementSettings = new ArrayList<>();
    DefaultCheckBox currentCheckBox = null;

    public Table(KandynskyAlg alg) {
        add(new EmptyLabel());
        add(DefaultCheckBox.builder()
                .label("background")
                .initValue(KandynskySettings.settings.isDrawBackground())
                .onClick(() -> KandynskySettings.settings.setDrawBackground(!KandynskySettings.settings.isDrawBackground()))
                .build());
        add(new EmptyLabel());
        row();
        add(new EmptyLabel());
        add(DefaultCheckBox.builder()
                .label("rotate")
                .initValue(KandynskySettings.settings.isRotate())
                .onClick(() -> KandynskySettings.settings.setRotate(!KandynskySettings.settings.isRotate()))
                .build());
        row();
        addRow(SelectBoxRow.<EditMode>builder()
                .label("edit mode")
                .selected(KandynskySettings.settings.getEditMode())
                .onChange(editMode -> {
                    KandynskySettings.settings.setEditMode(editMode);
                    alg.unselect();
                })
                .items(EditMode.values())
                .build());
        add(new EmptyLabel());
        add(DefaultCheckBox.builder()
                .label("CIRCLE")
                .initValue(false)
                .consumeIsChecked((checkbox, isChecked) -> onChangeCreateCheckBox(alg, Shape.CIRCLE, isChecked, checkbox))
                .build());
        row();
        add(new EmptyLabel());
        add(DefaultCheckBox.builder()
                .label("SEMICIRCLE")
                .initValue(false)
                .consumeIsChecked((checkbox, isChecked) -> onChangeCreateCheckBox(alg, Shape.SEMICIRCLE, isChecked, checkbox))
                .build());
        row();
        add(new EmptyLabel());
        add(DefaultCheckBox.builder()
                .label("QUARTER_CIRCLE")
                .initValue(false)
                .consumeIsChecked((checkbox, isChecked) -> onChangeCreateCheckBox(alg, Shape.QUARTER_CIRCLE, isChecked, checkbox))
                .build());
        row();
        add(new EmptyLabel());
        add(DefaultCheckBox.builder()
                .label("LINE")
                .initValue(false)
                .consumeIsChecked((checkbox, isChecked) -> onChangeCreateCheckBox(alg, Shape.LINE, isChecked, checkbox))
                .build());
        row();
        add(new EmptyLabel());
        add(new DefaultButton("delete element", alg::deleteElement));
        row();
        add(new EmptyLabel());
        add(new DefaultButton("save", alg::save));
        row();
        add(new EmptyLabel());
        add(new DefaultButton("clear", alg::clear));
    }

    private void onChangeCreateCheckBox(KandynskyAlg alg, Shape shape, Boolean isChecked, DefaultCheckBox checkbox) {
        if (currentCheckBox != null && currentCheckBox != checkbox) {
            currentCheckBox.toggle();
        }
        if (isChecked) {
            if (currentCheckBox == checkbox) {
                currentCheckBox = null;
            }
            KandynskySettings.settings.setShape(null);
            KandynskySettings.settings.setEditMode(EditMode.SELECT);
        } else {
            currentCheckBox = checkbox;
            KandynskySettings.settings.setEditMode(EditMode.CREATE);
            KandynskySettings.settings.setShape(shape);
            alg.unselect();
        }
    }

    void addSelectedElement(Element selectedElement) {
        removeSelectedElementSettings();
        row();
        if (selectedElement instanceof CircleElement circle) {
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("x")
                    .initValue(circle::getX)
                    .onValueChange((str) -> circle.setX(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("y")
                    .initValue(circle::getY)
                    .onValueChange((str) -> circle.setY(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("radius")
                    .initValue(circle::getRadius)
                    .onValueChange((str) -> circle.setRadius(parseInt(str)))
                    .build());
        }
        if (selectedElement instanceof LineElement line) {
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("x1")
                    .initValue(line::getXStart)
                    .onValueChange((str) -> line.setXStart(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("y1")
                    .initValue(line::getYStart)
                    .onValueChange((str) -> line.setYStart(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("x2")
                    .initValue(line::getXEnd)
                    .onValueChange((str) -> line.setXEnd(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("y2")
                    .initValue(line::getYStart)
                    .onValueChange((str) -> line.setYEnd(parseInt(str)))
                    .build());
        }
        if (selectedElement instanceof SemiCircleElement semiCircle) {
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("x")
                    .initValue(semiCircle::getX)
                    .onValueChange((str) -> semiCircle.setX(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("y")
                    .initValue(semiCircle::getY)
                    .onValueChange((str) -> semiCircle.setY(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("radius")
                    .initValue(semiCircle::getRadius)
                    .onValueChange((str) -> semiCircle.setRadius(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("rotation")
                    .initValue(semiCircle::getRotation)
                    .onValueChange((str) -> semiCircle.setRotation(parseInt(str)))
                    .build());
        }
        if (selectedElement instanceof QuarterCircle quarterCircle) {
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("x")
                    .initValue(quarterCircle::getX)
                    .onValueChange((str) -> quarterCircle.setX(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("y")
                    .initValue(quarterCircle::getY)
                    .onValueChange((str) -> quarterCircle.setY(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("radius")
                    .initValue(quarterCircle::getRadius)
                    .onValueChange((str) -> quarterCircle.setRadius(parseInt(str)))
                    .build());
            addSettingsRow(InteractiveSettingsRow.builder()
                    .label("rotation")
                    .initValue(quarterCircle::getRotation)
                    .onValueChange((str) -> quarterCircle.setRotation(parseInt(str)))
                    .build());
        }

    }

    private void addSettingsRow(InteractiveSettingsRow interactiveSettingsRow) {
        addRow(interactiveSettingsRow.getDefaultSettingsRow());
        selectedElementSettings.add(interactiveSettingsRow);
    }

    void updateFields() {
        selectedElementSettings.forEach(InteractiveSettingsRow::updateTextField);
    }

    private void removeSelectedElementSettings() {
        for (InteractiveSettingsRow selectedElementSetting : selectedElementSettings) {
            removeActor(selectedElementSetting.getDefaultSettingsRow().getLabel());
            removeActor(selectedElementSetting.getDefaultSettingsRow().getWidget());
        }
        selectedElementSettings.clear();
    }
}
