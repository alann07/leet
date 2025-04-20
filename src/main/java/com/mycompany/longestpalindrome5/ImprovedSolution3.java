package com.mycompany.longestpalindrome5;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * below saves memory by not using list. save some time on list parsing operations too. but space saving is big.
 * Beats 94.6%.
 *
 * 198ms Beats 24.47%, 42.02MB Beats 94.60%
 * 178ms Beats 27.82% (another running after removing checking for isPalindrome for those already shorter than
 * the length of existing maxSubString
 **/
public class ImprovedSolution3 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        return dp(s, 0, s.substring(0,1));
    }

    private String dp(String s, int index, String maxSubString) {
        if (index >= s.length()) return "";
        for(int i=s.length()-1; i>index; i--) {
            if (i-index+1 > maxSubString.length() && isPalindrome(s, index, i)) {
                if (i+1-index > maxSubString.length()) {
                    maxSubString = s.substring(index, i+1);
                }
                if (i==s.length()-1) {
                    return maxSubString;
                }
                break;
            }
        }
        String curr = dp(s, index + 1, maxSubString);
        return maxSubString.length() > curr.length() ? maxSubString : curr;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (s == null || s.isEmpty()) return false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
