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
        int win = 0;
        int life = 0;
        Ascii ascii = new Ascii();

        while (life <= 8 || win == randomWord.length()) {
            clearConsole();
            System.out.println("Word: " + randomWord);
            System.out.println(ascii.get_Ascii(life));

            System.out.println("Word: " + chara);
            System.out.println("Guess");
            String temp = chara;
            char g = scanner.next().charAt(0);
            Guess guess = new Guess(randomWord, chara, g);
            String yGuess = guess.get_input(randomWord, chara, g);

            if (temp.equals(yGuess)) {
                life++;
                if (life == 8) {
                    clearConsole();
                    System.out.println(ascii.get_Ascii(life));

                }
            } else {
                chara = yGuess;
                System.out.println("After guess : " + chara);
                System.out.println(randomWord.length());
                win++;
                if (win == randomWord.length()) {
                    System.out.println("Vous avez gagnez");
                }
            }

        }

        scanner.close();
    }

}
