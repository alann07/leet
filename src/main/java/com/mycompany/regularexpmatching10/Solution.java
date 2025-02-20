package com.mycompany.regularexpmatching10;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || p.isEmpty() || p.startsWith("*")) return false;
        if (".*".equals(p)) return true;

        return (findSolution(s, p));
    }

    private boolean findSolution(String s, String pattern) {
        char pchar = 0;
        int p = 0;
        boolean subMatch = true;
        int i=0;
        while (true) {
            boolean isStar = false;
            boolean isDot = false;
            switch (pattern.charAt(p)) {
                case '.':
                    isDot = true;
                    break;
                case '*':
                    isStar = true;
                    pchar = pattern.charAt(p - 1);
                    break;
                default:
                    pchar = pattern.charAt(p);
                    break;
            }

            if (isDot) {
                if (s.isEmpty()) {
                    subMatch = false;
                    break;
                }
                p++;
                i++;
            } else if (isStar) {
                if (s.isEmpty() && p<pattern.length()-1) return findSolution(s, pattern.substring(p+1));
                if (pchar == '.') {
                    // if * is not at the end of the pattern, still need to move to right.
                    if (p<pattern.length()-1 && pattern.charAt(p+1) == s.charAt(i)) {
                        p++;
                        subMatch = true;
                    } else if (p<pattern.length()-1 && pattern.charAt(p+1) != s.charAt(i)) {
                        subMatch = false;
                        i++;
                    } else {
                        i++;
                    }
                } else if (s.charAt(i) != pchar) {
                    p++;
                } else {
                    i++;
                }
            } else {
                if (s.isEmpty()) {
                    if( p + 1 == pattern.length()-1 &&
                        pattern.charAt(p + 1) == '*') {
                        break;
                    } else {
                        subMatch = false;
                        break;
                    }
                }

                if (s.charAt(i) == pchar) {
                    i++;
                    p++;
                } else if (s.charAt(i) != pchar &&
                        p + 1 < pattern.length() &&
                        pattern.charAt(p + 1) == '*') {
                    p++;
                } else {
                    subMatch = false;
                    break;
                }
            }

            if (i == s.length() && p == pattern.length()) {
                break;
            }

            if (i == s.length() && p < pattern.length()) {
                if (pattern.charAt(p) != '*') {
                    subMatch = findSolution("", pattern.substring(p));
                } else if (p < pattern.length()-1) {
                    subMatch = findSolution(s.substring(i-1), pattern.substring(p+1));
                }
                break;
            }

            if (i < s.length() && p == pattern.length()) {
                subMatch = false;
                break;
            }
        }
        return subMatch;
    }
}
