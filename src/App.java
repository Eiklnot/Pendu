import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            boolean opt = true;
            while (opt == true) {
                System.out.println("1- play");
                System.out.println("2- quit");
                int choice = scan.nextInt();

                if (choice == 1) {
                    Game game = new Game("words.csv");
                    game.run();
                } else {
                    System.out.println("Leaving the game");
                    opt = false;
                }
            }
        }
    }
}
