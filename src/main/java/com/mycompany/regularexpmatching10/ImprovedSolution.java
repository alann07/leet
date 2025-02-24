package com.mycompany.regularexpmatching10;

public class ImprovedSolution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || p.isEmpty() || p.startsWith("*")) return false;
        if (".*".equals(p)) return true;

        return findSolution(s, 0, p, 0);
    }

    private boolean findSolution(String s, int i, String pattern, int p) {
        if (p==pattern.length()) return i==s.length();

        if (p==pattern.length()-1 || pattern.charAt(p+1) != '*') {
            if (isCharMatching(s,i,pattern,p)) return findSolution(s,i+1, pattern, p+1);
            return false;
        } else {
            if (findSolution(s,i,pattern,p+2)) return true;
            while(isCharMatching(s,i,pattern,p)) {
                if (findSolution(s, ++i, pattern, p+2)) return true;
            }
            return false;
        }
    }

    private boolean isCharMatching(String s, int i, String pattern, int p) {
        if (s.length() == i) return pattern.length() == p;
        if (pattern.length() == p) return s.length() == i;
        return pattern.charAt(p) == '.' || pattern.charAt(p) == s.charAt(i);
    }
}
