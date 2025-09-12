import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Scanner;

public class Player {
    private String username;
    private int Highscore;
    private int totalCoins;
    private int totalDistance;
    private UUID playerID;
    private LocalDateTime createdAt;

    public Player(String username){
        this.username = username;
    }

    public UUID getPlayerID(UUID playerID){
        return playerID;
    }

    public void updateHighScore(int newScore){
        if(newScore >= Highscore){
            Highscore = newScore;
        }
    }

    public void addCoins(int coins){
        totalCoins += coins;
    }

    public void addDistance(int distance){
        totalDistance += distance;
    }

    public void showDetail(){
        System.out.println("Player ID : " + playerID
                + "Username : " + username
                + "High Score: " + Highscore
                + "Total Coins: " + totalCoins
                + "Total Distance: " + totalDistance
                + "Created At: " + createdAt);
    }

}
