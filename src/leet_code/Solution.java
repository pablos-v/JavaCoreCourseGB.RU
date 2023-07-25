package leet_code;

/**
 * https://leetcode.com/problems/circular-array-loop/
 */
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int turt, rabb, direction;
        for (int i = 0; i < nums.length; i++) {
            turt = i;
            rabb = i;
            if (nums[rabb] > 0) direction = 1; // up movement
            else direction = 0; // down movement

            for (int j = i; j < nums.length; j++) {

                turt = move(nums, turt, 1);
                if (turt == move(nums, turt, 1)) break; // self-cycled
                System.out.print(turt + " ");

                if ((direction == 1 && nums[rabb] < 0) || (direction == 1 && nums[move(nums,rabb,1)] < 0)) break; // changed direction
                if ((direction == 0 && nums[rabb] > 0) || (direction == 0 && nums[move(nums,rabb,1)] > 0)) break; // changed direction
                rabb = move(nums, rabb, 2);
                System.out.print(rabb + "|");
                if (turt == rabb) return true;
            }
        }
        return false;
    }

    public int move(int[] where, int idx, int howFar) {
        for (int i = 0; i < howFar; i++) {
            idx += where[idx];
            if (idx >= where.length) {
                while (idx >= where.length) {
                    idx -= where.length;
                }
            } else {
                while (idx < 0) {
                    idx += where.length;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, -1, 1, 2, 2};
        int[] nums2 = {-1, -2, -3, -4, -5, 6};
        int[] nums3 = {1, -1, 5, 1, 4};
        int[] nums4 = {-1,-2,-3,-4,-5};
        int[] nums5 = {1,1,1,1,1,1,1,1,1,-5};
        System.out.println(" nums = " + s.circularArrayLoop(nums));
        System.out.println(" nums2 = " + s.circularArrayLoop(nums2));
        System.out.println(" nums3 = " + s.circularArrayLoop(nums3));
        System.out.println(" nums4 = " + s.circularArrayLoop(nums4));
        System.out.println(" nums5 = " + s.circularArrayLoop(nums5));
    }
}