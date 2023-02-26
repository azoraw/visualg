package com.visualg.animations.waveFuncCollapse.texture;

import java.util.function.BiFunction;

record TextureRule(int indexElement, BiFunction<Integer, Integer, Boolean> activeCellsFunction) {
}
