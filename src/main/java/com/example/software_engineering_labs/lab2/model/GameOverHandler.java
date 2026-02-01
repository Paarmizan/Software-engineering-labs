package com.example.software_engineering_labs.lab2.model;

public class GameOverHandler extends Handler {

    private final GameModel model;

    public GameOverHandler(Handler next, GameModel model) {
        super(next);
        this.model = model;
    }

    @Override
    public boolean process(Integer request) {
        model.setState(GameState.WRONG);
        return true;
    }
}
