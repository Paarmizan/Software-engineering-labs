package com.example.software_engineering_labs.lab2.model;

public class GuessCheckHandler extends Handler {

    private final GameModel model;

    public GuessCheckHandler(Handler next, GameModel model) {
        super(next);
        this.model = model;
    }

    @Override
    public boolean process(Integer request) {
        if (request == model.getSecretNumber()) {
            model.setState(GameState.WIN);
            return false;
        }
        return super.process(request);
    }
}
