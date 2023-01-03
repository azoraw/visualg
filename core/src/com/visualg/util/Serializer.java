package com.visualg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    private static final String folderPath = "data" + File.separator;

    public static void serialize(Object o, String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(folderPath + filename + ".txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(o);
        } catch (IOException ignored) {
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static Object deserialize(String filename) {
        final File file = new File(folderPath + filename + ".txt");
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException ignored) {
        }
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ignored) {
        }
        return null;
    }
}
