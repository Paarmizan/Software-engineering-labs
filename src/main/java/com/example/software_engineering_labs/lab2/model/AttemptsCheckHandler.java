package com.example.software_engineering_labs.lab2.model;

public class AttemptsCheckHandler extends Handler {

    private final GameModel model;

    public AttemptsCheckHandler(Handler next, GameModel model) {
        super(next);
        this.model = model;
    }

    @Override
    public boolean process(Integer request) {
        if (!model.hasAttempts()) {
            model.setState(GameState.LOSE);
            return false;
        }
        model.decrementAttempts();
        return super.process(request);
    }
}
