class Combinations {
    StringBuilder out = new StringBuilder();
    final String in;

    Combinations(final String in) {
        this.in = in;
    }

    public void combine(int start) {
        for (int i = start; i < in.length(); i++) {
            out.append(in.charAt(i));
            System.out.println(out.toString());
            combine(i + 1);
            out.setLength(out.length() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations objCombinations = new Combinations("king");
        objCombinations.combine(0);
    }
}