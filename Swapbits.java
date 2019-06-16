class Swapbits {

    public static void main(String[] args) {
        int n = 137;

        // 0 index denotes least significant bit
        int i = 0, j = 6;

        int binary_number = computeBinary(n);
        System.out.println(n + " in binary system is " + binary_number);
        int swapped_number = swap(n, i, j);
        System.out.println("Bits in position " + i + " and " + j + " are getting swapped");
        System.out.println(swapped_number + " in binary system is " + computeBinary(swapped_number));
        System.out.println("Binary number after swapping is " + swapped_number);
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
     * function to swap the ith and jth bit in a number n
     */
    public static int swap(int n, int i, int j) {
        int x = (n >> i) & 1;
        int y = (n >> j) & 1;
        if (x != y) {
            if (x == 0) {
                n = n - (1 << j) + (1 << i);
                System.out.println(1 << j);
            } else {
                n = n - (1 << i) + (1 << j);
            }
        }
        return n;
    }
}