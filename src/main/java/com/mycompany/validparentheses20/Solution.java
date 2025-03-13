package com.mycompany.validparentheses20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
 * is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * 3ms Beats 42.01%, 41.97MB Beats 31.84%
 */
public class Solution {
    private static final Map<Character, Character> closeCharMap;
    static {
        closeCharMap = new HashMap<>();
        closeCharMap.put('}', '{');
        closeCharMap.put(']', '[');
        closeCharMap.put(')', '(');
    }
    private static final Map<Character, Character> openCharMap;
    static {
        openCharMap = new HashMap<>();
        openCharMap.put('{', '}');
        openCharMap.put('[', ']');
        openCharMap.put('(', ')');
    }
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (openCharMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != closeCharMap.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
