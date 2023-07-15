package leet_code;

import java.util.Arrays;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as
 * objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also
 * consists of three different numbers that is why it is called Dutch National Flag problem.
 * <p>
 * Example 1:
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * <p>
 * Example 2:
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
class Solution {

    static int TWO = 2;
    static int ZERO = 0;

    public static void dnf(int[] arr) {
        int c = 0;
        int fin = arr.length - 1;
        int start = 0;
        for (int i = 0; i <= fin; i++) {
            System.out.printf("for %d%n", c++);
            if (arr[i] == TWO) {
                int j = fin;
                while (j > i) {
            System.out.printf("while-2 %d%n", c++);
                    if (arr[j] != TWO) {
                        int tmp = arr[j];
                        arr[j] = TWO;
                        arr[i] = tmp;
                        fin--;
                        break;
                    }
                    fin--;
                    j--;
                }
            }
            if (arr[i] == ZERO) {
                int j = start;
                while (j < i) {
            System.out.printf("while-0 %d%n", c++);
                    if (arr[j] != ZERO) {
                        int tmp = arr[j];
                        arr[j] = ZERO;
                        arr[i] = tmp;
                        start = j + 1;
                        break;
                    }
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
        int[] arr = new int[]{1, 2, 0, 1, 2, 1, 1, 2, 0, 1, 2, 1,1, 2, 0, 1, 2, 1, 1, 2, 0, 1, 2, 1};
        Solution.dnf(arr);
        System.out.println(Arrays.toString(arr));
    }
}