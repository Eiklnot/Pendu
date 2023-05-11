import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            CSVHandler csvHandler = new CSVHandler("/home/eiklnot/Desktop/Computer Science/java/java_project/Pendu/words.csv");
            String randomWord = csvHandler.getRandomWord("/home/eiklnot/Desktop/Computer Science/java/java_project/Pendu/words.csv");

            NumLetters numLetters = new NumLetters(randomWord);
            String chara = numLetters.get_lines(randomWord);
            
            
            System.out.println("Word: " + randomWord);

            int life =0;
            Ascii ascii = new Ascii();

            do {

                System.out.println("Word: " + chara);
                char g = scanner.next().charAt(0);
                Guess guess = new Guess(randomWord, chara, g);
                System.out.println("Guess");
                String yGuess = guess.get_input(randomWord, chara, g);

                if (yGuess.equals("wrong")){
                    System.out.println(ascii.get_Ascii(life));
                    life++;
                }else{
                    chara = yGuess;
                    System.out.println("After guess : " + chara);
                }
            }
            while (life < 10);

        }
    }
}
