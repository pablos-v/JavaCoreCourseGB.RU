package leet_code;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        StringBuilder substr = new StringBuilder();
        if (s.length() != 0) {
            substr.append(s.charAt(0));
            res = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (substr.toString().contains(String.valueOf(s.charAt(i)))) { // если есть этот символ в подстроке
                if (substr.length() > res)
                    res = substr.length(); // запомнить длину подстроки, если она больше результата
                i = substr.toString().indexOf(s.charAt(i)) + 1 + start; // сдвинуть цикл на ячейку,
                // следующую за первым вхождением в подстроке
                substr = new StringBuilder();
                start = i;
            }
            substr.append(s.charAt(i));
        }
        if (substr.length() > res) res = substr.length();
        return res;
    }
//        for (int i = 0; i < s.length(); i++) {
//            if (s.substring(i).length() == setLength(s.substring(i))){
//                return s.substring(i).length();
//            }
//        }
//        return 0;
//
//    }
//
//    int setLength(String s){
//        Set<Character> chars = new HashSet<>();
//        for( char c : s.toCharArray() ) {
//            chars.add(c);
//        }
//        return chars.toArray().length;
//    }

    public static void main(String[] args) {
        Solution ll = new Solution();

        System.out.println(ll.lengthOfLongestSubstring("pwwkew"));
    }
}