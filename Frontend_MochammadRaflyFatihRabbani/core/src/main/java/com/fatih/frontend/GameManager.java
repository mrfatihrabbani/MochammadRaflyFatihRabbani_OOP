package com.fatih.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.fatih.frontend.observers.Observer;
import com.fatih.frontend.observers.ScoreManager;
import com.fatih.frontend.observers.Subject;
import com.fatih.frontend.services.BackendService;

import static com.badlogic.gdx.utils.JsonWriter.OutputType.json;

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
                    JsonValue json = new JsonReader().parse(response);
                    currentPlayerId = json.getString("playerId");
                    Gdx.app.log("savedId", "Player ID has been successfully saved with ID : " + currentPlayerId);
                } catch (Exception error){
                    Gdx.app.error("error", "Player ID failed to be saved : " + response);
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

        int finalScore = scoreManager.getScore() + coinsCollected * 10;
        score = scoreManager.getScore();
        int distance = scoreManager.getScore();

        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("submit","Score successfully submitted : "  + response);
            }

            @Override
            public void onError(String error) {
                Gdx.app.log("submit", "Score failed to submit : " + error);
            }
        });
    }

    public void addCoin(){
        coinsCollected++;
        Gdx.app.log("addCoin","COIN COLLECTED! Total: " + coinsCollected);
    }

    public void setScore(int distance) {
        if (gameActive) {
            scoreManager.setScore(distance);
        }
    }

    // Getters
    public int getScore() { return scoreManager.getScore(); }

    public int getCoins(){
        return coinsCollected;
    }

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
