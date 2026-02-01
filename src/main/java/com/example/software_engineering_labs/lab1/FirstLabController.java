package com.example.software_engineering_labs.lab1;

import com.example.software_engineering_labs.lab1.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class FirstLabController {

    public Label timeLabel;
    public Circle signalCircle;
    public Rectangle animationRect;
    @FXML private Label serverStateLabel;

    private TimeServer timeServer;

    public void initialize() {
        timeServer = new TimeServer();

        timeServer.attach(new TimeLabelObserver(timeLabel));
        timeServer.attach(new SignalObserver(signalCircle));
        timeServer.attach(new AnimationObserver(animationRect));
        timeServer.attach(new ServerStateObserver(serverStateLabel));
    }

    public void startServer() {
        timeServer.start();
    }

    public void stopServer() {
        timeServer.stop();
    }
}