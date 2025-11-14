package com.fatih.frontend;

import com.fatih.frontend.observers.Observer;
import com.fatih.frontend.observers.ScoreManager;
import com.fatih.frontend.observers.Subject;

public class GameManager implements Subject {
    private static GameManager instance;

    private ScoreManager scoreManager;

    private int score;
    private boolean gameActive;

    private GameManager() {
        score = 0;
        gameActive = false;
        scoreManager = new ScoreManager();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        score = 0;
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore) {
        if (gameActive) {
            scoreManager.setScore(newScore);
        }
    }

    // Getters
    public int getScore() { return scoreManager.getScore(); }

    @Override
    public void addObserver(Observer observer) {
        scoreManager.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        scoreManager.removeObserver(observer);
    }

    @Override
    public void notifyObserver(int score) {
        scoreManager.notifyObserver(score);
    }
}
