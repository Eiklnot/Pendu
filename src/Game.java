import java.util.Scanner;

public class Game {
    private String randomWord;
    private String chara;
    private Scanner scanner;

    // Constructeur qui initialise le jeu
    public Game(String filename) {
        // Lecture du fichier CSV et récupération d'un mot aléatoire
        CSVHandler csvHandler = new CSVHandler(filename);
        randomWord = csvHandler.getRandomWord(filename);
        
        // Conversion du mot aléatoire en tirets bas (_)
        NumLetters numLetters = new NumLetters(randomWord);
        chara = numLetters.get_lines(randomWord);
        
        // Initialisation du scanner pour lire les entrées utilisateur
        scanner = new Scanner(System.in);
    }

    // Méthode pour effacer le terminal
    public static void clearConsole() {
        // Code existant pour effacer le terminal en fonction du système d'exploitation
    }

    // Méthode principale pour exécuter le jeu
    public void run() {
        // Variable pour compter le nombre de vies restantes
        int life = 0;
        
        // Instance de la classe Ascii pour afficher l'état du pendu
        Ascii ascii = new Ascii();
        
        // Boucle pour gérer la continuité du jeu
        boolean choice = true;
        
        while (choice) {

            // Boucle principale du jeu
            do {
                // Efface le terminal et affiche le mot caché
                clearConsole();
                System.out.println("Word: " + randomWord);
                System.out.println(ascii.get_Ascii(life));
                System.out.println("Word: " + chara);
                System.out.println("Guess");
                
                // Sauvegarde de l'état actuel du mot caché
                String temp = chara;

                // Lecture et traitement de la saisie de l'utilisateur
                char g = scanner.next().charAt(0);
                Guess guess = new Guess(randomWord, chara, g);
                String yGuess = guess.get_input(randomWord, chara, g);

                // Efface le terminal et affiche le mot caché après la saisie utilisateur
                clearConsole();
                System.out.println("Word: " + randomWord);
                System.out.println(ascii.get_Ascii(life));

                // Compare l'état précédent et le nouvel état du mot caché pour mettre à jour les vies
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

            } while (life < 8 && !randomWord.equals(chara)); // Condition de fin de partie

            // Affichage du résultat de la partie
            if (randomWord.equals(chara)) {
                System.out.println("Vous avez gagner");
            } else {
                System.out.println("Vous avez perdu. Le mot était : " + randomWord);
            }

            // Demande pour rejouer
            System.out.println("Play again?\n1- play\n2- quit");
            int inp = scanner.nextInt();
            if (inp == 1) {
                // Relance une nouvelle partie
                Game game = new Game("words.csv");
                game.run();
            } else {
                // Sortie du programme
                System.out.println("Leaving the program");
                choice = false;
            }
        }

        scanner.close();
    }
}
