package com.visualg.util.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import lombok.Getter;

import java.time.LocalDateTime;

public class ScreenShotUtil {

    private static final String SCREEN_SHOTS_PATH = "screenShots/";
    private static String recordStartTimestamp;
    @Getter
    private static boolean scheduledToRecordOnNextAnimationStart;
    @Getter
    private static boolean recording = false;
    @Getter
    private static int frameCount;
    private static Runnable onFrameCountChange;

    public static void take(Pixmap pixmap) {
        PixmapIO.writePNG(Gdx.files.local(screenshotPath()), pixmap);
        pixmap.dispose();
    }

    private static String screenshotPath() {
        return SCREEN_SHOTS_PATH
                + getCurrentTimeString()
                + ".png";
    }

    private static String recordPath() {
        return SCREEN_SHOTS_PATH
                + recordStartTimestamp
                + "/"
                + frameCount
                + ".png";
    }

    private static String getCurrentTimeString() {
        return LocalDateTime.now().toString()
        .replace("-", "_")
        .replace(":", "_");
    }

    public static void prepareRecording() {
        recordStartTimestamp = getCurrentTimeString();
        recording = true;
    }

    public static void finishRecording() {
        recording = false;
        frameCount = 0;
        onFrameCountChange.run();
    }

    public static void record(Pixmap pixmap) {
        if(!recording) {
            throw new RuntimeException("Before recording call prepareRecording method");
        }
        PixmapIO.writePNG(Gdx.files.local(recordPath()), pixmap);
        pixmap.dispose();
        frameCount++;
        onFrameCountChange.run();
    }

    public static void scheduleRecordingOnNextAnimationStart() {
        scheduledToRecordOnNextAnimationStart = true;
    }

    public static void notifyOnFrameChanged(Runnable onFrameCountChange) {
        ScreenShotUtil.onFrameCountChange = onFrameCountChange;
    }
}
