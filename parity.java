class parity {

    public static void main(String[] args) {
        int x = 10, x1 = 10;

        // prints 0 if even parity and 1 if odd parity
        System.out.println(checkParity(x));
        System.out.println(checkParityImproved(x));

        // prints the binary equivalent of a decimal number
        System.out.println(computeBinary(x1));
    }

    public static int computeBinary(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int result = 0;
        result = (n % 2) + 10 * computeBinary(n / 2);
        return result;
    }

    /*
     * -----------Returns the parity of a number - 0 if even and 1 if odd -------
     * n&1 returns the least significant bit everytime if 1 is encountered earlier,
     * it XOR's making it 0, else 1 is retained
     */
    public static int checkParity(int n) {
        int result = 0;
        while (n != 0) {
            result = result ^ (n & 1);
            n = n >> 1;
        }
        return result;
    }

    /**
     * -----------Returns the parity of a number - 0 if even and 1 if odd ----------
     * In every iteration, it sets the bit in n to 0 if bits do not match or if it
     * both the comparing bits are 0.
     */
    public static int checkParityImproved(int n) {
        int result = 0;
        while (n != 0) {
            result = result ^ 1;
            n = n & (n - 1);
        }
        return result;
    }
}