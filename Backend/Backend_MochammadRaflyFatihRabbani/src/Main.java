import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player("Bob");
        Player player2 = new Player("Gordon Ramsey");

        Score score1 = new Score(player1,1500, 250, 5000);
        Score score2 = new Score(player1,3200, 750, 12000);
        Score score3 = new Score(player1,1800, 300, 6000);


    }
}