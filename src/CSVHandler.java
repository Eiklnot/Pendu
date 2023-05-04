import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class CSVHandler {


    public CSVHandler(String filePath) {
    }

    public String getRandomWord() {
        ArrayList<String> words = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/eiklnot/Desktop/Computer Science/java/java_project/Pendu/words.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                // Do something with each line of the CSV file
                words.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(words);
        
        return words.get(0);   
    }
}
