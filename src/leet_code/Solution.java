package leet_code;

/**
 * Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.
 * <p>
 * For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }.
 * The index to be replaced is 7 to get a continuous sequence of length 6 containing all 1’s.
 */
class Solution {

    public int findIndex(int[] arr) {
        int len, idx = 0, res = 0, lenPrevious = 0, left = 0;
        boolean isPreviousZero = false;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {

                if (isPreviousZero) {

                    len = right - left;
                    if (len > lenPrevious) {
                        res = idx;
                        lenPrevious = len;
                    }

                    left = right;
                    isPreviousZero = false;

                } else {
                    isPreviousZero = true;
                    left++;
                }

                idx = right;

            } else {
                isPreviousZero = false;
            }

            len = right - left + 1;
            if (len > lenPrevious) {
                res = idx;
                lenPrevious = len;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findIndex(new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}));
        System.out.println(s.findIndex(new int[]{1, 0, 1, 1, 0, 0, 0, 1, 1}));
    }
}