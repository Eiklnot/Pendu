import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class CSVHandler {
    private String filePath;

    public CSVHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getRandomWord(String filePath) {
        ArrayList<String> words = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
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
