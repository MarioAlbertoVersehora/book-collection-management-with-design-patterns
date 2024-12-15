package com.example.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class BookObserver {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}

interface Subscriber {
    void update(String message);
}