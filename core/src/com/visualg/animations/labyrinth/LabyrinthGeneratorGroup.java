package com.visualg.animations.labyrinth;

import com.badlogic.gdx.scenes.scene2d.Group;

public class LabyrinthGeneratorGroup extends Group {
    public LabyrinthGeneratorGroup() {
        LabyrinthGeneratorActor labyrinthGeneratorActor = new LabyrinthGeneratorActor();
        LabyrinthGeneratorController controller = new LabyrinthGeneratorController(labyrinthGeneratorActor);
        addActor(labyrinthGeneratorActor);
        Table settings = new Table(controller);
        addActor(settings);
    }
}
