package com.visualg.animations.spiral.strangeAlgs;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.ui.pixmap.PixmapActor;
import com.visualg.util.libgdx.ScreenShotUtil;

public class StrangeSpiralGroup extends Group  {

    public StrangeSpiralGroup() {
        final StrangeSpiralAlg alg = new StrangeSpiralAlg();
        PixmapActor pixmapActor = new PixmapActor(alg);
        addActor(pixmapActor);
        addActor(new Table(() -> ScreenShotUtil.take(alg.getPixMap())));
    }

}
