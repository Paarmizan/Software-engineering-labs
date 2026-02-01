package com.example.software_engineering_labs.lab1.model;

import java.util.*;

public class TimeServer implements Subject {

    private int timeState = 0;
    private Timer timer;
    private TimerTask task;
    private boolean active = false;

    private List<IObserver> observers = new ArrayList<>();

    public void start() {
        if (active) return;

        active = true;
        timer = new Timer();

        task = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };

        timer.schedule(task, 0, 1000);
    }

    public void stop() {
        active = false;
        if (timer != null) {
            timer.cancel();
        }
        notifyAllObservers();
    }

    private void tick() {
        timeState++;
        notifyAllObservers();
    }

    @Override
    public int getState() {
        return timeState;
    }

    @Override
    public void attach(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void detach(IObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyAllObservers() {
        for (IObserver obs : observers) {
            obs.update(this);
        }
    }

    public boolean isActive() {
        return active;
    }
}
