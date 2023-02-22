package com.visualg.controls.fileio;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

import static java.util.Optional.ofNullable;

public class UserProperties {
    private static final String FILE_PATH = "user.properties";
    private static final String UI_SCALE_PATH = "uiScale";
    private static final String VOLUME_PATH = "volume";
    private static final String MUTE_PATH = "mute";
    private final Properties properties;

    @SneakyThrows
    public UserProperties() {
        properties = new Properties();
        File file = new File(FILE_PATH);
        file.createNewFile();
        properties.load(new FileInputStream(file));
    }

    public boolean isMute() {
        return ofNullable(properties.getProperty(MUTE_PATH))
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    public int getVolume() {
        return ofNullable(properties.getProperty(VOLUME_PATH))
                .map(Integer::parseInt)
                .orElse(100);
    }

    public float getUiScale() {
        return ofNullable(properties.getProperty(UI_SCALE_PATH))
                .map(Float::parseFloat)
                .orElse(1f);
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
