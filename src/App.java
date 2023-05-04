public class App {
    public static void main(String[] args) throws Exception {
        CSVHandler csvHandler = new CSVHandler("path/to/your/csv/file.csv");
        String randomWord = csvHandler.getRandomWord();
        NumLetters numLetters = new NumLetters(randomWord);
        System.out.println("Random word: " + numLetters.get_lines(randomWord));


    }
}
