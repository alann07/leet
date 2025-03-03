package com.mycompany.palindrome131;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Minor tweak on top of "ImprovedSolution" to use index to detect isPalindrome, instead of substring.
 *
 * 7ms Beats 97.17%, 57.03MB Beats 43.75%
 */
public class ImprovedSolution3 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length()<1) return result;

        findSolution(s, 0, result, new ArrayList<>());
        return result;
    }

    private void findSolution(String s, int index, List<List<String>> result, List<String> temp) {

        if (index == s.length() && !temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i+1));
                findSolution(s, i+1, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
