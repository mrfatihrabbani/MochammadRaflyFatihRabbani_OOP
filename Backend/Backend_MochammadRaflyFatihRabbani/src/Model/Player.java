package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Player implements ShowDetail{
    private String username;
    private int highscore;
    private int totalCoins;
    private int totalDistance;
    private UUID playerID;
    private LocalDateTime createdAt;

    public Player(String username){
        this.username = username;
        this.playerID = UUID.randomUUID();
        this.highscore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getPlayerID(){
        return playerID;
    }

    public String getUsername() {
        return username;
    }

    public int getHighScore() {
        return highscore;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void updateHighScore(int newScore){
        if(newScore >= highscore){
            highscore = newScore;
        }
    }

    public void addCoins(int coins){
        totalCoins += coins;
    }



    public void addDistance(int distance){
        totalDistance += distance;
    }

    public void showDetail(){
        System.out.println("Model.Player ID : " + playerID + "\n"
                + "Username : " + username + "\n"
                + "High Model.Score: " + highscore + "\n"
                + "Total Coins: " + totalCoins + "\n"
                + "Total Distance: " + totalDistance + "\n"
                + "Created At: " + createdAt + "\n");
    }

}
