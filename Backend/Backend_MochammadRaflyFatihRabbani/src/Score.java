import java.time.LocalDateTime;
import java.util.UUID;

public class Score {
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

    }
    public int getValue(){
        return value;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getDistance(){
        return distance;
    }

    public void showDetail(){
        System.out.println("Score ID : " + scoreID
                + "playerID : " + playerID
                + "High Score: " + getValue()
                + "Coins Collected: " + getCoinsCollected()
                + "Distance: " + getDistance()
                + "Created At: " + createdAt);
    }
}
