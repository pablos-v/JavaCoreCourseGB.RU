package leet_code;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string and a positive number k, find the longest substring of the string containing k distinct characters.
 * If k is more than the total number of distinct characters in the string, return the whole string.
 */
class Solution {

    public String finder(String str, int k) {

        if (str == null || str.length() == 0) return str;

        // stores the longest substring boundaries
        int end = 0, begin = 0;

        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();

        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0;

        for (int right = 0; right < str.length(); right++) {
            window.add(str.charAt(right));

            int val = freq.getOrDefault(str.charAt(right), 0);
            freq.put(str.charAt(right), ++val);

            // if the window size is more than `k`, remove characters from the left
            while (window.size() > k) {
                val = freq.get(str.charAt(left));
                freq.put(str.charAt(left), --val);
                // If the leftmost character's frequency becomes 0 after
                // removing it in the window, remove it from the set as well
                if (freq.get(str.charAt(left)) == 0) window.remove(str.charAt(left));
                left++;        // reduce window size
            }

            // update the maximum window size if necessary
            if (end - begin < right - left) {
                end = right;
                begin = left;
            }
        }

        // return the longest substring found at `str[begin…end]`
        return str.substring(begin, end + 1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.finder("abcbdbdbbdcdabd", 2).equals("bdbdbbd"));
        System.out.println(s.finder("abcbdbdbbdcdabd", 5).equals("abcbdbdbbdcdabd"));
        System.out.println(s.finder("abcbdbdbbdcdabd", 3).equals("bcbdbdbbdcd"));
        System.out.println(s.finder("ggwwweqqq", 3).equals("wwweqqq"));

    }
}