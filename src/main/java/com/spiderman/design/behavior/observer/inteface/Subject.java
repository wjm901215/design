package com.spiderman.design.behavior.observer.inteface;

import com.spiderman.design.behavior.observer.Message;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}
