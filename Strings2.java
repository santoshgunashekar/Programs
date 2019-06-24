/**
 * Write an effiient function that deletes characters from an ASCII string. Use
 * the prototype string removeChars( string str, string remove ); where any
 * character existing in remove must be deleted from str. For example, given a
 * str of"Battle of the Vowels: Hawaii vs. Grozny" and a remove of "aeiou" , the
 * function should transform str to “Bttl f th Vwls: Hw vs. Grzny” . Justify any
 * design decisions you make, and discuss the effiiency of your solution.
 */
// This algorithm works in O(n+m) where n and m are length of the source word
// and the remove word respectively
class Strings2 {
    public static void main(String[] args) {
        String word = "Hello there";
        String remove = "aeiou";
        int start = 0;
        char[] source = word.toCharArray();
        char[] delete = remove.toCharArray();

        boolean[] set = new boolean[128];

        for (int i = 0; i < delete.length; i++) {
            set[delete[i]] = true;
        }

        for (int i = 0; i < source.length; i++) {
            if (!set[source[i]]) {
                source[start++] = source[i];
            }
        }
        System.out.println(new String(source, 0, start));
    }
}