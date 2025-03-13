package com.mycompany.validparentheses20;

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
 * 2ms Beats 97.67%
 */
public class ImprovedSolution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                stack.push('}');
            } else if (c == '[' ) {
                stack.push(']');
            } else if ( c=='(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
