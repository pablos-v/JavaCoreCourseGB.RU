package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(start -> start[0]));

        ArrayList<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (end >= s){
                end = Math.max(end, e);
            }
            else {
                res.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{1, 3}, {8, 10},{2, 6},  {15, 18}};
        System.out.println(Arrays.deepToString(s.merge(intervals)));
    }
}