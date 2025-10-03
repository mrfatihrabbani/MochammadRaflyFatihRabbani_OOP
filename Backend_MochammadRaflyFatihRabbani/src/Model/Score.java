package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Score implements ShowDetail{
    private UUID scoreID;
    private UUID playerID;
    private Player player;
    private int value;
    private int coinsCollected;
    private int distance;
    private LocalDateTime createdAt;

    public Score(UUID playerID, int value, int coinsCollected, int distance){
        this.playerID = playerID;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distance = distance;
        this.scoreID = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }
    public int getValue(){
        return value;
    }

    public Object getPlayerId() { return playerID; }

    public UUID getScoreId() { return scoreID; }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getDistance(){
        return distance;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void showDetail(){
        System.out.println("Model.Score ID : " + scoreID + "\n"
                + "playerID : " + playerID + "\n"
                + "High Model.Score: " + getValue() + "\n"
                + "Coins Collected: " + getCoinsCollected() + "\n"
                + "Distance: " + getDistance() + "\n"
                + "Created At: " + createdAt + "\n" );
    }
}
