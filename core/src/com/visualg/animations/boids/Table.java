package com.visualg.animations.boids;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class Table extends SettingsTable {

    Table(BoidsSettings boidsSettings) {

        DefaultSettingsRow numberOfBoids = DefaultSettingsRow.builder()
                .label("number of boids: ")
                .initValue(valueOf(boidsSettings.getNumberOfBoids()))
                .onValueChange(newValue -> boidsSettings.setNumberOfBoids(parseInt(newValue)))
                .afterValueChange(value -> fire(new RestartEvent()))
                .build();
        addRow(numberOfBoids);

        DefaultSettingsRow maxSpeed = DefaultSettingsRow.builder()
                .label("max speed: ")
                .initValue(valueOf(boidsSettings.getMaxSpeed()))
                .onValueChange(newValue -> boidsSettings.setMaxSpeed(parseInt(newValue)))
                .build();
        addRow(maxSpeed);

        DefaultSettingsRow minSpeed = DefaultSettingsRow.builder()
                .label("min speed: ")
                .initValue(valueOf(boidsSettings.getMinSpeed()))
                .onValueChange(newValue -> boidsSettings.setMinSpeed(parseInt(newValue)))
                .build();
        addRow(minSpeed);

        DefaultSettingsRow alignForce = DefaultSettingsRow.builder()
                .label("alignment force: ")
                .initValue(valueOf(boidsSettings.getAlignmentForce()))
                .onValueChange(newValue -> boidsSettings.setAlignmentForce(parseDouble(newValue)))
                .build();
        addRow(alignForce);

        DefaultSettingsRow cohForce = DefaultSettingsRow.builder()
                .label("cohesion force: ")
                .initValue(valueOf(boidsSettings.getCohesionForce()))
                .onValueChange(newValue -> boidsSettings.setCohesionForce(parseDouble(newValue)))
                .build();
        addRow(cohForce);


        DefaultSettingsRow collisionForce = DefaultSettingsRow.builder()
                .label("collision repulsion force: ")
                .initValue(valueOf(boidsSettings.getCollisionRepulsionForce()))
                .onValueChange(newValue -> boidsSettings.setCollisionRepulsionForce(parseDouble(newValue)))
                .build();
        addRow(collisionForce);

        DefaultSettingsRow neighbourRadius = DefaultSettingsRow.builder()
                .label("neighbour radius: ")
                .initValue(valueOf(boidsSettings.getNeighbourRadius()))
                .onValueChange(newValue -> boidsSettings.setNeighbourRadius(parseInt(newValue)))
                .build();
        addRow(neighbourRadius);

        DefaultSettingsRow circleSize = DefaultSettingsRow.builder()
                .label("circle radius size: ")
                .initValue(valueOf(boidsSettings.getCircleRadius()))
                .onValueChange(newValue -> boidsSettings.setCircleRadius(parseInt(newValue)))
                .build();
        addRow(circleSize);

    }
}

