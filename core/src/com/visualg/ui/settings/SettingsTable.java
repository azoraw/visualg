package com.visualg.ui.settings;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.EmptyLabel;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class SettingsTable extends Table {

    public SettingsTable() {
        setSize(WIDTH, HEIGHT);
        bottom().left();
        emptyRow();
        emptyRow();
        add(new DefaultLabel("Settings"));
        row();
    }

    private void emptyRow() {
        add(new EmptyLabel());
        row();
    }

    protected void addRow(SettingsRow settingsRow) {
        add(settingsRow.getLabel());
        add(settingsRow.getWidget());
        row();
    }

    @SneakyThrows
    public void addNumericRows(Settings settingsInstance) {
        Class<?> settingsClass = settingsInstance.getClass();
        Field[] fields = settingsClass.getDeclaredFields();
        for (Field field : fields) {
            if (isNumericType(field.getType())) {
                String label = field.getName();
                Object initialValue = getInitialValue(settingsInstance, field);
                addRow(DefaultSettingsRow.builder()
                        .label(label)
                        .initValue(initialValue)
                        .onValueChange(str -> {
                            Object parsedValue = parseValue(str, field.getType());
                            try {
                                String setterName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                                Method setterMethod = settingsClass.getDeclaredMethod(setterName, field.getType());
                                setterMethod.setAccessible(true);
                                setterMethod.invoke(settingsInstance, parsedValue);
                                fire(new RestartEvent());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .build());
            }
        }
    }

    @SneakyThrows
    private Object getInitialValue(Object instance, Field field) {
        String getterName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        Method getterMethod = instance.getClass().getMethod(getterName);
        getterMethod.setAccessible(true);
        return getterMethod.invoke(instance);
    }

    private Object parseValue(String str, Class<?> type) {
        return switch (type.getSimpleName()) {
            case "int", "Integer" -> Integer.parseInt(str);
            case "float", "Float" -> Float.parseFloat(str);
            case "double", "Double" -> Double.parseDouble(str);
            default -> throw new IllegalArgumentException("Unsupported numeric type: " + type.getSimpleName());
        };
    }

    private boolean isNumericType(Class<?> type) {
        return type == int.class || type == Integer.class ||
                type == float.class || type == Float.class ||
                type == double.class || type == Double.class;
    }
}
