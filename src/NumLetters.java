public class NumLetters {

    public String randomWord;

    // Constructeur qui prend un mot aléatoire en paramètre
    public NumLetters (String randomWord) {
        this.randomWord = randomWord;
    }

    // Méthode pour convertir le mot aléatoire en tirets bas (_)
    public String get_lines(String randomWord) {
        String lines = randomWord;
        char ch = '_';

        // Crée un StringBuilder pour modifier le mot
        StringBuilder sb = new StringBuilder(lines);

        // Remplace chaque lettre par un tiret bas (_)
        for (int i = 0; i < lines.length(); i++) {
            sb.setCharAt(i, ch);
        }

        // Convertit le StringBuilder en String
        lines = sb.toString();
        return lines;
    }
}
