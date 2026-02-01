package com.example.software_engineering_labs.lab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecondLabApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                SecondLabApplication.class.getResource(
                        "game-view.fxml"
                )
        );

        Scene scene = new Scene(loader.load(), 800, 600);

        stage.setTitle("Лабораторная №2 — Цепочка обязанностей");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
