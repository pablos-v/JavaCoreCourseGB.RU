package leet_code;

/**
 * Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target.
 * * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * * You can return the answer in any order.
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) return new int[]{i, j};
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int t = 4;
        for (int i : twoSum(arr,t)) System.out.println(i);
    }
}
