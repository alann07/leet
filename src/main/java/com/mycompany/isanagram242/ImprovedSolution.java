package com.mycompany.isanagram242;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Initial solution: map +1 from s, and -1 from s, then check map.values() has all 0;
 * 24ms Beats 8.32%, 43.02MB Beats 84.37%
 *
 * Extact +1 and -1 to its own function helps reduce from 24ms to 12ms.
 * 12ms Beats 32.44%, 43.23MB Beats 73.96%
 *
 * 1 more improvement is to remove the key if value becomes 0, then we can check map.isEmpty().
 * However, it's 13ms.
 *
 * */
public class ImprovedSolution {
    public boolean isAnagram(String s, String t) {
        if (s==null || s.isEmpty() || t==null || t.isEmpty() || t.length() != s.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                touchHash(map, s.charAt(i), true);
                touchHash(map, t.charAt(i), false);
            }
        }

//        for (Integer val : map.values()) {
//            if (val == null || val != 0) return false;
//        }

        return map.isEmpty();
    }

    private void touchHash(Map<Character, Integer> map, char c, boolean doAdd) {
        Integer val = map.get(c);
        if (val == null) {
            map.put(c, doAdd? 1 : -1);
        } else {
            if (doAdd) {
                val++;
            } else {
                val--;
            }
            if (val == 0) {
                map.remove(c);
            } else {
                map.put(c, val);
            }
        }
    }
}
