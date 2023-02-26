package com.visualg.animations.bezier;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class BezierSettings implements Settings {
    static final BezierSettings settings = new BezierSettings();

    private int numberOfBlobs = 1;
    private List<BlobSetting> blobs = initBlobs();

    private List<BlobSetting> initBlobs() {
        final ArrayList<BlobSetting> blobs = new ArrayList<>();
        for (int i = 0; i < numberOfBlobs; i++) {
            blobs.add(new BlobSetting());
        }
        return blobs;
    }

    void setNumberOfBlobs(int numberOfBlobs) {
        this.numberOfBlobs = numberOfBlobs;
        blobs = initBlobs();
    }

    BlobSetting getBlobSetting(int index) {
        return blobs.get(index);
    }
}

@Data
class BlobSetting {
    private float transparency = 0.01f;
    private float transparency2 = 0.01f;
    private boolean gradient = false;
    private BlobColor blobColor = BlobColor.RANDOM;
    private BlobColor blobColor2 = BlobColor.RANDOM;

}