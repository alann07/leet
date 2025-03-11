package com.mycompany.reversewords151;

/**
 *Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should
 * only have a single space separating the words. Do not include any extra spaces.
 *
 * First submit, 4ms Beats 95.92% 43.43MB Beats 42.31%
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        int end=-1;
        boolean foundFirst = false;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                if (foundFirst) {
                    foundFirst = false;
                        sb.append(s.substring(i+1, end + 1) + " ");
                }
            }
            else {
                if (!foundFirst) {
                    foundFirst=true;
                    end = i;
                }
                if (i==0) {
                    sb.append(s.substring(i, end + 1));
                }
            }
        }
        if (sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
