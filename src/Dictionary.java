import java.util.ArrayList;

public class Dictionary {
    ArrayList<String> words = new ArrayList<String>();

    public Dictionary () {

    }

    public void addWord (final String s) {
        words.add(s.toLowerCase());
    }
    
    public ArrayList<String> getWordsThatMatch (final char[] in, final ArrayList<Character> guessed) {
        ArrayList<String> result = new ArrayList<String>();
        for (String s : words) {
            if (s.length() == in.length) {
                outer:
                for (int i = 0; i < in.length; i++) {
                    if (in[i] != '_') {
                        if (s.charAt(i) == in[i]) {
                            if (i == in.length - 1) {
                                result.add(s);
                            }
                        } else {
                            break;
                        }
                    } else if (i == in.length - 1) {
                        result.add(s);
                    } else {
                        for (char c : guessed) {
                            if (c == s.charAt(i)) {
                                break outer;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
