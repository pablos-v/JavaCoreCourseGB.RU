package leet_code;

import java.util.HashSet;

/**
 Given a string, find the length of the longest substring in it with no more than K distinct characters.

 Example 1:
 Input: String="araaci", K=2
 Output: 4
 Explanation: The longest substring with no more than '2' distinct characters is "araa".

 Example 2:
 Input: String="araaci", K=1
 Output: 2
 Explanation: The longest substring with no more than '1' distinct characters is "aa".

 Example 3:
 Input: String="cbbebi", K=3
 Output: 5
 */
class Solution {

    public int countSubstring(String str, int K){
        int res = 0;
        if (K <= 0) return res;
        HashSet<Character> set = new HashSet<>();

        for (int j = 0; j < str.length(); j++) {
            for (int i = j; i < str.length(); i++) {
                set.add(str.charAt(i));
                if (set.size() > K) break;
                if (set.size() == K) res = Math.max(res, i-j+1);
            }
            set.clear();

        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstring("araaci", 2) == 4);
        System.out.println(s.countSubstring("araaci", 1) == 2);
        System.out.println(s.countSubstring("fxcbbebi", 3) == 5);
        System.out.println(s.countSubstring("rrrrr", 1) == 5);
    }
}