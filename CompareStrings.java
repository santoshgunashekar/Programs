class CompareStrings {
    public static String[] split(String S) {
        String[] words = S.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        return words;
    }

    public static int getCount(String s, char ch) {
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (ch == s.charAt(j)) {
                count++;
            }
        }
        return count;
    }

    public static int[] getCountOfAllWords(String[] S) {
        int counters[] = new int[S.length];
        for (int i = 0; i < S.length; i++) {
            String s = S[i];
            char ch = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) < s.charAt(j - 1)) {
                    ch = s.charAt(j);
                }
            }
            counters[i] = getCount(s, ch);
        }
        return counters;
    }

    public static void main(String[] args) {

        String A = "abcd aabc bd";
        String B = "aaa aa";
        String words_1[] = split(A);
        String words_2[] = split(B);

        int counter_1[] = new int[words_1.length];
        int counter_2[] = new int[words_2.length];

        counter_1 = getCountOfAllWords(words_1);
        counter_2 = getCountOfAllWords(words_2);

        int result[] = new int[words_2.length];
        for (int i = 0; i < words_2.length; i++) {
            int count = 0;
            for (int j = 0; j < words_1.length; j++) {
                if (counter_2[i] > counter_1[j]) {
                    count++;
                }
            }
            result[i] = count;
        }

        for (int i = 0; i < words_2.length; i++) {
            System.out.print(result[i] + " ");
        }
        // result is [3 2] since the first string in second array is greater than 3
        // strings in first array and the second string in second array is greater than
        // 2 of the strings from first array
    }
}