import Model.Player;
import Model.Score;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player("Bob");
        Player player2 = new Player("Gordon Ramsey");

        Score score1 = new Score(player1.getPlayerID(),1500, 250, 5000);
        Score score2 = new Score(player2.getPlayerID(),3200, 750, 12000);
        Score score3 = new Score(player1.getPlayerID(),1800, 300, 6000);

        player1.updateHighScore(score1.getValue());
        player2.updateHighScore(score2.getValue());
        player1.updateHighScore(score3.getValue());

        player1.addCoins(score1.getCoinsCollected());
        player2.addCoins(score2.getCoinsCollected());
        player1.addCoins(score3.getCoinsCollected());

        player1.addDistance(score1.getDistance());
        player1.addDistance(score3.getDistance());
        player2.addDistance(score2.getDistance());

        System.out.println("========================== Model.Player Details ==========================");
        player1.showDetail();
        player2.showDetail();

        score1.showDetail();

    }
}