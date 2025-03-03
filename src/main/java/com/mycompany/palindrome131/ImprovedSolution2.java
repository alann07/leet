package com.mycompany.palindrome131;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Use HashMap or HashSet to store the isPalindrome result actually slows down. It might be due to collision.
 *
 * 12ms Beats 12.78%
 */
public class ImprovedSolution2 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length()<1) return result;

        Map<String, Boolean> cache = new HashMap<>();
        findSolution(s, 0, result, new ArrayList<>(), cache);
        return result;
    }

    private void findSolution(String s, int index, List<List<String>> result, List<String> temp, Map<String, Boolean> cache) {

        if (index == s.length() && !temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i+1);
            if (isPalindrome(sub, cache)) {
                temp.add(sub);
                findSolution(s, i+1, result, temp, cache);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String temp, Map<String, Boolean> cache) {
        if(temp.length() > 1) {
            Boolean matched = cache.get(temp);
            if (matched != null) {
                return matched;
            }
        }
        int i=0, j=temp.length()-1;
        while(i<j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                cache.put(temp, false);
                return false;
            }
            i++;
            j--;
        }
        cache.put(temp, true);
        return true;
    }
}
