class LargestArray {

    public static int[][] createSubArrays(int[] A, int K) {
        int number_of_blocks = A.length + 1 - K;
        int sub_arrays[][] = new int[number_of_blocks][K];

        for (int i = 0; i < number_of_blocks; i++) {
            for (int j = i, k = 0; k < K; j++, k++) {
                sub_arrays[i][k] = A[j];
            }
        }
        return sub_arrays;
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 3, 2, 5 };
        int K = 4;

        int number_of_blocks = A.length + 1 - K;
        int sub_arrays[][] = new int[number_of_blocks][K];
        sub_arrays = createSubArrays(A, K);

        int max_array_index = 0;
        for (int i = 1; i < number_of_blocks; i++) {
            for (int j = 0; j < K; j++) {
                if (sub_arrays[i][j] > sub_arrays[i - 1][j]) {
                    max_array_index = i;
                    break;
                }
                if (sub_arrays[i][j] == sub_arrays[i - 1][j]) {
                    continue;
                }
            }
        }
        System.out.println("The largest subarray of size " + K + " is:");
        for (int i = 0; i < K; i++) {
            System.out.print(sub_arrays[max_array_index][i] + " ");
        }
    }
}