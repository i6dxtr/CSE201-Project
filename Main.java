import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a name.");
        String name = sc.nextLine();
        game.initializeGame(name);
        game.startGame();
    }
}
