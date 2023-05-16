import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CSVHandler {
    public CSVHandler(String filePath) {
    }

    public String getRandomWord(String filePath) {
        // Crée une liste pour stocker les mots
        ArrayList<String> words = new ArrayList<>();
        
        // Lit le fichier CSV
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            // Ajoute chaque mot dans la liste
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
            // Ferme le fichier
            br.close();
        } catch (IOException e) {
            // Affiche l'erreur en cas de problème
            e.printStackTrace();
        }
        
        // Mélange la liste de mots
        Collections.shuffle(words);

        // Retourne le premier mot de la liste mélangée
        return words.get(0);   
    }
}
