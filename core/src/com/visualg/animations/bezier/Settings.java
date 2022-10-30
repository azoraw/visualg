package com.visualg.animations.bezier;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Settings {
    static final Settings INSTANCE = new Settings();
    private int numberOfBlobs = 1;
    private List<BlobSetting> blobs = initBlobs();

    private List<BlobSetting> initBlobs() {
        final ArrayList<BlobSetting> blobs = new ArrayList<>();
        for (int i = 0; i < numberOfBlobs; i++) {
            blobs.add(new BlobSetting());
        }
        return blobs;
    }

    public void setNumberOfBlobs(int numberOfBlobs) {
        this.numberOfBlobs = numberOfBlobs;
        blobs = initBlobs();
    }
    public BlobSetting getBlobSetting(int index) {
        return blobs.get(index);
    }
}

@Data
class BlobSetting {
    private float transparency = 0.01f;
    private float transparency2 = 0.01f;
    private boolean gradient = false;
    private BlobColor blobColor = BlobColor.PRIMARY;
    private BlobColor blobColor2 = BlobColor.PRIMARY;

}