package com.visualg.global;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class UserProperties {
    private static final String FILE_PATH = "user.properties";
    private static final String UI_SCALE_PATH = "uiScale";
    private static final String VOLUME_PATH = "volume";
    private static final String MUTE_PATH = "mute";
    private final  Properties properties;

    @SneakyThrows
    public UserProperties() {
        properties = new Properties();
        properties.load(new FileInputStream(FILE_PATH));
    }

    public boolean isMute() {
        return parseBoolean(properties.getProperty(MUTE_PATH));
    }

    public int getVolume() {
        return parseInt(properties.getProperty(VOLUME_PATH));
    }

    public float getUiScale() {
        return parseFloat(properties.getProperty(UI_SCALE_PATH));
    }

    @SneakyThrows
    public void saveUiScale(float newValue) {
        properties.setProperty(UI_SCALE_PATH, String.valueOf(newValue));
        properties.store(new FileWriter(FILE_PATH), null);
    }

    @SneakyThrows
    public void saveVolume(int newValue) {
        properties.setProperty(VOLUME_PATH, String.valueOf(newValue));
        properties.store(new FileWriter(FILE_PATH), null);
    }

    @SneakyThrows
    public void saveMute(boolean newValue) {
        properties.setProperty(MUTE_PATH, String.valueOf(newValue));
        properties.store(new FileWriter(FILE_PATH), null);
    }
}
