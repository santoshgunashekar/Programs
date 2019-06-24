/**
 * Write an effiient function to fid the fist nonrepeated character in a string.
 * For instance, the fist nonrepeated character in “total” is 'o' and the fist
 * nonrepeated character in “teeter” is 'r'. Discuss the effiiency of your
 * algorithm.
 */
class Strings1 {
    public static void main(String[] args) {
        String word = "apocalypse", newWord;
        newWord = word;
        word = word.toUpperCase();
        int[] countArray = new int[26];
        for (int i = 0; i < 26; i++) {
            countArray[i] = 0;
        }

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 65;
            countArray[index]++;
        }

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 65;
            if (countArray[index] == 1) {
                System.out.println(newWord.charAt(i));
                break;
            }
        }
    }
}