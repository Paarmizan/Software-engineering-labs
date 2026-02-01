package com.example.software_engineering_labs.lab1.model;

import javafx.application.Platform;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationObserver implements IObserver {

    private Rectangle rect;

    public AnimationObserver(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void update(Subject subject) {
        if (subject.getState() % 5 == 0) {
            Platform.runLater(this::animate);
        }
    }

    private void animate() {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(2), rect);
        tt.setFromX(0);
        tt.setToX(200);
        tt.setAutoReverse(true);
        tt.setCycleCount(2);
        tt.play();
    }
}
