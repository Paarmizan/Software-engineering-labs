package com.example.software_engineering_labs.lab2.model;

public abstract class Handler {

    protected Handler processor;

    public Handler(Handler processor) {
        this.processor = processor;
    }

    public boolean process(Integer request) {
        if (processor != null)
            return processor.process(request);
        else
            return true;
    }
}
