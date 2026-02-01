package com.example.software_engineering_labs.lab2.model;

public class RangeCheckHandler extends Handler {

    private final GameModel model;

    public RangeCheckHandler(Handler next, GameModel model) {
        super(next);
        this.model = model;
    }

    @Override
    public boolean process(Integer request) {
        if (request < 1 || request > 10) {
            model.setState(GameState.OUT_OF_RANGE);
            return false;
        }
        return super.process(request);
    }
}


