package com.fatih.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.fatih.frontend.observers.Observer;
import com.fatih.frontend.observers.ScoreManager;
import com.fatih.frontend.observers.Subject;
import com.fatih.frontend.services.BackendService;

public class GameManager implements Subject {
    private static GameManager instance;

    private ScoreManager scoreManager;

    private int score;
    private boolean gameActive;

    private BackendService backendService;
    private String currentPlayerId = null;
    private int coinsCollected = 0;

    private GameManager() {
        score = 0;
        gameActive = false;
        scoreManager = new ScoreManager();
        backendService = new BackendService();
    }

    public void registerPlayer(String username){
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    new JsonReader().parse(response);
                    currentPlayerId = "playerId";

                } catch (Error error){
                    Gdx.app.error("error", response);
                }
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("error", error);
            }
        });
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
        coinsCollected = 0;
    }

    public void endGame(){
        if(currentPlayerId == null){
            return;
        }

        float finalScore = scoreManager.getScore() + coinsCollected * 10;
        score = scoreManager.getScore();

        backendService.submitScore(currentPlayerId,finalScore,coincount, distance);
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
