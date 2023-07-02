package leet_code;

import java.util.HashMap;

/**
 * Find all substrings of a string that contains all characters of another string.
 * In other words, find all substrings of the first string that are anagrams of the second string.
 * <p>
 * Please note that the problem specifically targets substrings that are contiguous
 * (i.e., occupy consecutive positions) and inherently maintains the order of elements.
 * <p>
 * For example,
 * <p>
 * The first string is 'XYYZXZYZXXYZ'
 * The second string is 'XYZ'
 * <p>
 * Anagram 'YZX' present at index 2
 * Anagram 'XZY' present at index 4
 * Anagram 'YZX' present at index 6
 * Anagram 'XYZ' present at index 9
 */
class Solution {

    public void finder(String one, String two) {
        HashMap<Character, Integer> twoMap = PablosLibrary.stringToMap(two);
        int windowSize = two.length();
        int left = 0;
        for (int right = windowSize - 1; right < one.length(); right++) {
            String window = one.substring(left, right + 1);
            HashMap<Character, Integer> winMap = PablosLibrary.stringToMap(window);
            if (winMap.equals(twoMap)) {
                System.out.println("Anagram " + window + " present at index " + left);
            }
            left++;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.finder("XYYZXZYZXXYZ", "XYZ");


    }
}