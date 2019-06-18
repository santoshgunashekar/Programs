class Separate {
    public static void main(String[] args) {
        String S = "2-4A0r7-4k";
        int K = 4;
        S = S.toUpperCase();
        int dash_count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                dash_count++;
            }
        }
        // System.out.println(dash_count);
        StringBuilder result = new StringBuilder();
        result.append("");
        int i = 0, k;
        if ((S.length() - dash_count) % K != 0) {
            for (i = 0, k = 0; k < ((S.length() - dash_count) % K); i++) {
                if (S.charAt(i) == '-') {
                    continue;
                } else {
                    result.append(S.charAt(i));
                    k++;
                }
            }
            result.append('-');
        }

        if (!(S.length() - dash_count == i)) {
            int count = 0;
            for (; i < S.length(); i++) {
                if (count % K == 0 & count != 0) {
                    result.append('-');
                }

                if (S.charAt(i) == '-') {
                    continue;
                } else {
                    result.append(S.charAt(i));
                    count++;
                }
            }
        }
        System.out.println(result.toString());
    }
}