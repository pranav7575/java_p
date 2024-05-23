
import java.util.*;

 class WordCounter{

    public int countUniqueWords(String text){
        HashSet<String> uniqueWords = new HashSet<String>();
        String[] words = text.split(" ");
        for(String word : words){
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }
}

public class J_MainHashset {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a text string: ");
    String inputText = scanner.nextLine();

    WordCounter wordCounter = new WordCounter();
    int uniqueWordCount = wordCounter.countUniqueWords(inputText);

    System.out.println("Number of unique words: " + uniqueWordCount);

    }}