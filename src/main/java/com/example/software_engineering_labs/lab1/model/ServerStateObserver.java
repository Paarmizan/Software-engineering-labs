package com.example.software_engineering_labs.lab1.model;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ServerStateObserver implements IObserver {

    private Label label;

    public ServerStateObserver(Label label) {
        this.label = label;
    }

    @Override
    public void update(Subject subject) {
        Platform.runLater(() -> {
            if (((TimeServer) subject).isActive()) {
                label.setText("Сервер: активен");
            } else {
                label.setText("Сервер: неактивен");
            }
        });
    }
}
