package com.fatih.frontend.observers;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager implements Subject{
    private List<Observer> observers;
    int score = 0;

    public ScoreManager(List<Observer> observers, int score){
        this.observers = new ArrayList<>();
        this.score = score;
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(int score) {
        for(Observer observer : observers){
            observer.update(score);
        }
    }

    public int getScore() {
        return score;
    }

}
