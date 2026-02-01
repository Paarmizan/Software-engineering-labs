package com.example.software_engineering_labs.lab1.model;

public interface Subject {
    void attach(IObserver obs);
    void detach(IObserver obs);
    void notifyAllObservers();
    int getState();
}

