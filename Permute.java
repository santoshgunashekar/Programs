import java.util.ArrayList;
import java.util.Iterator;

class Permute {
    static ArrayList<String> strings;

    public static void main(String[] args) {
        strings = new ArrayList<String>();
        String word = "kingse";
        int length = word.length();
        strings = permute(word);
        Iterator it;
        it = strings.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
        System.out.println("Size is " + strings.size());
    }

    public static ArrayList<String> permute(String word) {
        ArrayList<String> result = new ArrayList<String>();
        result.add(word.charAt(0) + "");
        Iterator it;
        int i = 1;
        it = result.iterator();
        do {
            result = permuteHelper(result, word.charAt(i));
            i++;
        } while (i < word.length());
        return result;
    }

    public static ArrayList<String> permuteHelper(ArrayList<String> word, char c) {
        ArrayList<String> result = new ArrayList<String>();
        String[] results;
        String[] words = new String[word.size()];
        Iterator it = word.iterator();
        int length = 0;
        while (it.hasNext()) {
            words[length++] = it.next().toString();
        }
        for (int i = 0; i < length; i++) {
            results = insert(words[i], c);
            for (int j = 0; j < results.length; j++) {
                result.add(results[j]);
            }
        }
        return result;
    }

    public static String[] insert(String word, char c) {
        String[] result = new String[word.length() + 1];
        for (int position = 0; position <= word.length(); position++) {
            result[position] = word.substring(0, position) + c + word.substring(position);
        }
        return result;
    }

}