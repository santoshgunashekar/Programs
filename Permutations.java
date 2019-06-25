class Permutations {
    final StringBuilder out = new StringBuilder();
    String in;
    boolean[] used;

    Permutations(final String in) {
        this.in = in;
        used = new boolean[in.length()];
    }

    public void permute() {
        if (out.length() == in.length()) {
            System.out.println(out);
            return;
        }
        for (int i = 0; i < in.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            out.append(in.charAt(i));
            permute();
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations objPermutations = new Permutations("kingselyp");
        objPermutations.permute();
    }
}