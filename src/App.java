import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- play\n2- quit");
        int inp;

        while (scanner.hasNextInt()) {
            inp = scanner.nextInt();
            if (inp == 1) {
                Game game = new Game("words.csv");
                game.run();
            } else {
                System.out.println("Leaving the program");
                break;
            }
            System.out.println("1- play\n2- quit");
        }

        scanner.close();
    }
}