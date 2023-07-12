package leet_code;

import java.util.Arrays;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * <p>
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * <p>
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
class Solution {

    public int[] squaredArray(int[] arr) {
//        int[] res = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            res[i] = (int) Math.pow(arr[i], 2);
//        }
//        Arrays.sort(res);
//        return res;

        int[] res = new int[arr.length];
        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                res[0] = (int) Math.pow(arr[i], 2);
                if (i < arr.length - 1) {
                    pointer2 = i + 1;
                }
                if (i > 0) {
                    pointer1 = i - 1;
                }
                break;
            }
        }
        if (pointer1 == 0 && pointer2 == 0) {
            int len = arr.length - 1;
            for (int i = 0; i < arr.length; i++) {
                res[i] = (int) Math.pow(arr[len--], 2);
            }
            return res;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            int sq1 = (int) Math.pow(arr[pointer1], 2);
            int sq2 = (int) Math.pow(arr[pointer2], 2);
            if (sq1 <= sq2) {
                res[i] = sq1;
                if (pointer1 > 0) {
                    pointer1--;
                } else {
                    for (int j = pointer2; j < arr.length; j++) {
                        res[j] = (int) Math.pow(arr[j], 2);
                    }
                    return res;
                }
            } else {
                res[i] = sq2;
                if (pointer2 < arr.length - 1) {
                    pointer2++;
                } else {
                    for (int j = pointer1; j >= 0; j--) {
                        res[pointer2++] = (int) Math.pow(arr[j], 2);
                    }
                    return res;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{-6, 0, 4, 5, 8 ,9};
        System.out.println(Arrays.toString(s.squaredArray(arr)));
    }
}