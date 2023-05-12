
public class Guess {
    
    
    public Guess(String randomWord, String lines, char guess) {
    }

    public String get_input(String randomWord, String lines, char guess) {

        char[] arrLines = lines.toCharArray();
        for (int i = 0; i < lines.length(); i++) {
            if(randomWord.charAt(i) == guess){
                arrLines[i] = guess;
            }
        }
        lines = new String(arrLines);
        return lines;

    }
}
