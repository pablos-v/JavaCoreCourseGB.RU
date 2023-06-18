package leet_code;

import java.util.*;

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

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.empty() && stack.peek().equals(map.get(s.charAt(i)))) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(){}["));
        System.out.println(s.isValid("(){}[]"));
        System.out.println(s.isValid("([])"));
    }
}