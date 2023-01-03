package com.visualg.animations.boids;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class Table extends SettingsTable {

    Table(Settings settings) {

        DefaultSettingsRow numberOfBoids = DefaultSettingsRow.builder()
                .label("number of boids: ")
                .initValue(valueOf(settings.getNumberOfBoids()))
                .onValueChange(newValue -> settings.setNumberOfBoids(parseInt(newValue)))
                .afterValueChange(value -> fire(new RestartEvent()))
                .build();
        addRow(numberOfBoids);

        DefaultSettingsRow maxSpeed = DefaultSettingsRow.builder()
                .label("max speed: ")
                .initValue(valueOf(settings.getMaxSpeed()))
                .onValueChange(newValue -> settings.setMaxSpeed(parseInt(newValue)))
                .build();
        addRow(maxSpeed);

        DefaultSettingsRow minSpeed = DefaultSettingsRow.builder()
                .label("min speed: ")
                .initValue(valueOf(settings.getMinSpeed()))
                .onValueChange(newValue -> settings.setMinSpeed(parseInt(newValue)))
                .build();
        addRow(minSpeed);

        DefaultSettingsRow alignForce = DefaultSettingsRow.builder()
                .label("alignment force: ")
                .initValue(valueOf(settings.getAlignmentForce()))
                .onValueChange(newValue -> settings.setAlignmentForce(parseDouble(newValue)))
                .build();
        addRow(alignForce);

        DefaultSettingsRow cohForce = DefaultSettingsRow.builder()
                .label("cohesion force: ")
                .initValue(valueOf(settings.getCohesionForce()))
                .onValueChange(newValue -> settings.setCohesionForce(parseDouble(newValue)))
                .build();
        addRow(cohForce);


        DefaultSettingsRow collisionForce = DefaultSettingsRow.builder()
                .label("collision repulsion force: ")
                .initValue(valueOf(settings.getCollisionRepulsionForce()))
                .onValueChange(newValue -> settings.setCollisionRepulsionForce(parseDouble(newValue)))
                .build();
        addRow(collisionForce);

        DefaultSettingsRow neighbourRadius = DefaultSettingsRow.builder()
                .label("neighbour radius: ")
                .initValue(valueOf(settings.getNeighbourRadius()))
                .onValueChange(newValue -> settings.setNeighbourRadius(parseInt(newValue)))
                .build();
        addRow(neighbourRadius);

        DefaultSettingsRow circleSize = DefaultSettingsRow.builder()
                .label("circle radius size: ")
                .initValue(valueOf(settings.getCircleRadius()))
                .onValueChange(newValue -> settings.setCircleRadius(parseInt(newValue)))
                .build();
        addRow(circleSize);

    }
}

