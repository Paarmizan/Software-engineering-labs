package com.example.software_engineering_labs.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstLabApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                FirstLabApplication.class.getResource("first-lab-view.fxml")
        );

        Scene scene = new Scene(loader.load(), 800, 600);

        stage.setTitle("Лабораторная №1 — Observer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}