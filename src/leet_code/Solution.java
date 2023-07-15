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
        int left = 0;
        int right = arr.length - 1;
        int[] res = new int[arr.length];
        int i = arr.length - 1;

        while (left < right) {
            int l = (int) Math.pow(arr[left], 2);
            int r = (int) Math.pow(arr[right], 2);
            if (l > r) {
                res[i--] = l;
                left++;
            } else {
                res[i--] = r;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{-7, -6, 0, 4, 5, 8, 9};
        System.out.println(Arrays.toString(s.squaredArray(arr)));
    }
}