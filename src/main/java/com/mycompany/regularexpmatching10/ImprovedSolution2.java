package com.mycompany.regularexpmatching10;

public class ImprovedSolution2 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || p.isEmpty() || p.startsWith("*")) return false;
        if (".*".equals(p)) return true;

        return (findSolution(s, 0, p, 0));
    }

    private boolean findSolution(String s, int i, String pattern, int p) {
        boolean subMatch = true;
        while (true) {
            if (pattern.length() == p) return s.length() == i;
            boolean isStar = pattern.charAt(p) == '*';

            if (!isStar) {
                if (p==pattern.length()-1 || pattern.charAt(p+1) != '*') {
                    if (!areCharsMatching(s, i, pattern, p)) {
                        return false;
                    }
                    i++;
                    p++;
                } else {
                    if (findSolution(s, i, pattern, p+2)) {
                        return true;
                    }
                    if (!areCharsMatching(s, ++i, pattern, p)) {
                        p = p + 2;
                    }
                    else if (!areCharsMatching(s, i-1, pattern, p)) {
                        return false;
                    }
//                    i++;
                }
            } else {
                p++;
            }

            if (i == s.length() && p == pattern.length()) {
                break;
            }

            if (i < s.length() && p == pattern.length()) {
                subMatch = false;
                break;
            }
        }
        return subMatch;
    }

    private boolean areCharsMatching(String s, int i, String pattern, int p) {
        if (s.length() <= i) return pattern.length() == p;
        if (pattern.length() == p) return s.length() == i;
        return pattern.charAt(p) == '.' || pattern.charAt(p) == s.charAt(i);
    }
}
