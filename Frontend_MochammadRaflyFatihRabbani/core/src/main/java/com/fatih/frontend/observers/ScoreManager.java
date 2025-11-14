package com.fatih.frontend.observers;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager implements Subject{
    private List<Observer> observers;
    int score;

    public ScoreManager(){
        this.observers = new ArrayList<>();
        this.score = 0;
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

    public void setScore(int newScore){
        if(newScore != score){
            score = newScore;
            notifyObserver(score);
        }
    }

    public int getScore() {
        return score;
    }

}
