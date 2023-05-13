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

    public void run() {
        System.out.println("Word: " + randomWord);

        int life =0;
        Ascii ascii = new Ascii();

        do {

            System.out.println("Word: " + chara);
            System.out.println("Guess");
            String temp = chara;
            char g = scanner.next().charAt(0);
            Guess guess = new Guess(randomWord, chara, g);
            String yGuess = guess.get_input(randomWord, chara, g);

            if (temp.equals(yGuess)){
                System.out.println(ascii.get_Ascii(life));
                life++;
            }else{
                chara = yGuess;
                System.out.println("After guess : " + chara);
            }

        } while (life < 9);

        scanner.close();
    }
}


