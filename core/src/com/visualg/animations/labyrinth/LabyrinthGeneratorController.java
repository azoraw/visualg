package com.visualg.animations.labyrinth;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class LabyrinthGeneratorController {
    private final LabyrinthGeneratorActor labyrinthGeneratorActor;

    void onSave() {
        labyrinthGeneratorActor.screenShot();
    }
}
