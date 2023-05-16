import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Création d'un scanner pour l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Affichage du menu
        System.out.println("1- play\n2- quit");
        
        // Variable pour le choix utilisateur
        int inp;

        // Boucle pour lire les choix utilisateur
        while (scanner.hasNextInt()) {
            // Stockage du choix utilisateur
            inp = scanner.nextInt();
            
            // Exécution du jeu si choix 1
            if (inp == 1) {
                Game game = new Game("words.csv");
                game.run();
            } else {
                // Sortie du programme sinon
                System.out.println("Leaving the program");
                break;
            }
            
            // Affichage du menu après chaque partie
            System.out.println("1- play\n2- quit");
        }

        // Fermeture du scanner
        scanner.close();
    }
}
