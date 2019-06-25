class Telephone {
    static StringBuilder str = new StringBuilder();
    static int totalWords = 0;

    public static char getKey(int telephoneKey, int place) {
        place = place - 1;
        char[] value = { 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W' };
        if (telephoneKey == 0 || telephoneKey == 1) {
            char ch = (char) ('0' + telephoneKey);
            return ch;
        } else {
            return (char) (value[telephoneKey - 2] + place);
        }
    }

    public static void getWord(int[] array, int start) {
        for (int i = start; i < array.length; i++) {
            int size = 3;
            if (array[i] == 7 || array[i] == 9) {
                size = 4;
            } else if (array[i] == 0 || array[i] == 1) {
                size = 1;
            }
            for (int j = 0; j < size; j++) {
                char ch = getKey(array[i], j + 1);
                str.append(ch + "");
                if (str.length() == array.length) {
                    System.out.println(str.toString());
                    totalWords++;
                }
                getWord(array, i + 1);
                str.setLength(str.length() - 1);
            }
        }
        // System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 4, 9, 7, 1 };
        getWord(array, 0);
        System.out.println("Total Words = " + totalWords);
    }
}