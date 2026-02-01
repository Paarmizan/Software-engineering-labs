package com.example.software_engineering_labs.lab1.model;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SignalObserver implements IObserver {

    private Circle circle;
    private boolean isRed = false;

    public SignalObserver(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void update(Subject subject) {
        int time = subject.getState();

        if (time % 3 == 0) {
            Platform.runLater(this::toggle);
        }
    }

    private void toggle() {
        isRed = !isRed;
        circle.setFill(isRed ? Color.RED : Color.GRAY);
    }
}
