package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
class Solution {
    /**
     * works only for consecutive characters...
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        try {
            for (int i = 0; i < s.length(); i++) {
                if (!(s.charAt(i + 1) == map.get(s.charAt(i++)))) return false;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(){}["));
        System.out.println(s.isValid("(){}[]"));
        System.out.println(s.isValid("("));
    }
}