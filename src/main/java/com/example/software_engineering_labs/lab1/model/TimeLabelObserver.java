package com.example.software_engineering_labs.lab1.model;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class TimeLabelObserver implements IObserver {

    private Label label;

    public TimeLabelObserver(Label label) {
        this.label = label;
    }

    @Override
    public void update(Subject subject) {
        Platform.runLater(() ->
                label.setText("Прошло " + subject.getState() + " с")
        );
    }
}
