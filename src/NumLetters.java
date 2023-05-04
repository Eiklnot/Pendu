public class NumLetters {

    public String randomWord;

    public NumLetters (String randomWord) {
        this.randomWord = randomWord;
    }

    public static String get_lines(String randomWord) {
        String lines = randomWord;
        char ch = '_';

        StringBuilder sb = new StringBuilder(lines);

        for (int i = 0; i < lines.length(); i++) {
            sb.setCharAt(i, ch);
        }
        lines = sb.toString();
        return lines;
    }
}