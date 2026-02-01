package com.example.software_engineering_labs.lab2.model;

public class GameModel {

    private final int secretNumber;
    private int attemptsLeft;
    private GameState state = GameState.NONE;

    public GameModel(int attempts) {
        this.secretNumber = (int)(Math.random() * 10) + 1;
        this.attemptsLeft = attempts;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean hasAttempts() {
        return attemptsLeft > 1;
    }

    public void decrementAttempts() {
        attemptsLeft--;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
