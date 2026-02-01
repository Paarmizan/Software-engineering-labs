package com.example.software_engineering_labs.lab2;

import com.example.software_engineering_labs.lab2.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {

    @FXML private TextField inputField;
    @FXML private Label resultLabel;
    @FXML private Label attemptsLabel;
    @FXML private Button checkButton;

    private GameModel model;
    private Handler chain;

    public GameController() {
    }

    @FXML
    public void initialize() {
        model = new GameModel(5);

        chain = new RangeCheckHandler(
                new AttemptsCheckHandler(
                        new GuessCheckHandler(
                                new GameOverHandler(null, model),
                                model
                        ),
                        model
                ),
                model
        );

        attemptsLabel.setText("Осталось попыток: " + model.getAttemptsLeft());
        resultLabel.setText("Введите число от 1 до 10");
    }

    @FXML
    private void onCheck() {
        try {
            int value = Integer.parseInt(inputField.getText());

            model.setState(GameState.NONE);

            chain.process(value);

            switch (model.getState()) {
                case WIN -> {
                    showAlert(
                            "Победа!",
                            "Вы угадали число 🎉"
                    );
                    checkButton.setDisable(true);
                    inputField.setDisable(true);
                    resultLabel.setText("Победа!");
                }
                case LOSE -> {
                    showAlert(
                            "Вы проиграли!",
                            "Загаданное число было: " + model.getSecretNumber()
                    );
                    checkButton.setDisable(true);
                    inputField.setDisable(true);
                    resultLabel.setText("Проигрыш!");
                }
                case OUT_OF_RANGE -> showAlert(
                        "Ошибка",
                        "Введите число от 1 до 10"
                );
                case WRONG -> resultLabel.setText("Неверно!");
                default -> {}
            }

            attemptsLabel.setText(
                    "Осталось попыток: " + model.getAttemptsLeft()
            );

        } catch (NumberFormatException e) {
            showAlert("Ошибка ввода", "Введите корректное число");
        }
    }

    private void showAlert(String title, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }
}
