import java.io.IOException;
import java.util.Scanner;

public class Game {
    private String randomWord;
    private String chara;
    private Scanner scanner;

    public Game(String filename) {
        CSVHandler csvHandler = new CSVHandler(filename);
        randomWord = csvHandler.getRandomWord(filename);
        NumLetters numLetters = new NumLetters(randomWord);
        chara = numLetters.get_lines(randomWord);
        scanner = new Scanner(System.in);
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        int life = 0;
        Ascii ascii = new Ascii();
        boolean choice = true;
        while (choice) {

            do {
                clearConsole();
                System.out.println("Word: " + randomWord);
                System.out.println(ascii.get_Ascii(life));

                System.out.println("Word: " + chara);
                System.out.println("Guess");
                String temp = chara;

                char g = scanner.next().charAt(0);
                Guess guess = new Guess(randomWord, chara, g);
                String yGuess = guess.get_input(randomWord, chara, g);

                clearConsole();
                System.out.println("Word: " + randomWord);
                System.out.println(ascii.get_Ascii(life));

                if (temp.equals(yGuess)) {
                    life++;
                    if (life == 8) {
                        clearConsole();
                        System.out.println(ascii.get_Ascii(life));
                    }
                } else {
                    chara = yGuess;
                    System.out.println("After guess : " + chara);
                }

            } while (life < 8 && !randomWord.equals(chara)); // Modifiez la condition ici

            if (randomWord.equals(chara)) {
                System.out.println("Vous avez gagner");
            } else {
                System.out.println("Vous avez perdu. Le mot était : " + randomWord);
            }

            System.out.println("Play again?\n1- play\n2- quit");
            int inp = scanner.nextInt();
            if (inp == 1) {
                Game game = new Game("words.csv");
                game.run();
            } else {
                System.out.println("Leaving the program");
                choice = false;
            }
        }

        scanner.close();
    }
}
