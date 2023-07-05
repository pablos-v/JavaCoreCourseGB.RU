package leet_code;

/**
 * Given a string, find the longest substring containing distinct characters.
 * The problem differs from the problem of finding the longest subsequence with distinct characters.
 * Unlike subsequences, substrings are required to occupy consecutive positions within
 * the original string.
 * <p>
 * Input:  findlongestsubstring
 * Output: The longest substring with all distinct characters is dlongest or ubstring
 * <p>
 * Input:  longestsubstr
 * Output: The longest substring with all distinct characters is longest
 * <p>
 * Input:  abbcdafeegh
 * Output: The longest substring with all distinct characters is bcdafe
 * <p>
 * Input:  aaaaaa
 * Output: The longest substring with all distinct characters is a
 */
class Solution {

    public void findlongestsubstring(String str) {
        String substring;
        String res = "";

        for (int right = 1, left = 0; right < str.length(); right++) {
            substring = str.substring(left, right);
            // окно подстроки растёт вправо, пока подстрока уникальна
            if (substring.length() != PablosLibrary.stringToSet(substring).size()) {
                // если не уникальна - результат сравнить и запомнить, левую границу сдвинуть
                if (res.length() < str.substring(left, right - 1).length()) res = str.substring(left, right - 1);
                left++;
            }
        }
        System.out.println(res);

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.findlongestsubstring("aaaaa");
        s.findlongestsubstring("findlongestsubstring");
        s.findlongestsubstring("longestsubstr");
        s.findlongestsubstring("abbcdafeegh");

    }
}