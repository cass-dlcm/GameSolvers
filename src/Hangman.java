import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    final static Dictionary d = new Dictionary();
    final static ArrayList<Character> guessed = new ArrayList<Character> ();
    
    static Scanner words;
    public static void main (final String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        words = new Scanner(new File(args[0]));
        String guess="";
        fillDictionary();
        while (in.hasNextLine()) {
            if(in.nextInt()==0) {
                in.nextLine();
                guess=in.nextLine();
                for (int i=0;i<guess.toCharArray().length;i++) {
                    if(guess.toCharArray()[i] != '_') {
                        guessed.add(guess.toCharArray()[i]);
                    }
                }
            } else {
                in.nextLine();
                guessed.add(in.nextLine().toCharArray()[0]);
            }
            System.out.println(d.getWordsThatMatch(guess.toCharArray(),guessed));
            if (d.getWordsThatMatch(guess.toCharArray(),guessed).size() == 1) {
                break;
            }
        }
    }
    
    public static void fillDictionary () {
        while (words.hasNextLine()) {
            d.addWord(words.nextLine());
        }
    }
}
