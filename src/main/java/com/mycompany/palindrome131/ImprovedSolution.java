package com.mycompany.palindrome131;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Wrong understanding of partition. i used the fixed partition, but in fact, it should be changeable for each iteration
 * and hence using backtrack recursion.
 *
 * 8ms Beats 55.60%, 56.88MB Beats 66.88%
 */
public class ImprovedSolution {

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
            String sub = s.substring(index, i+1);
            if (isPalindrome(sub)) {
                temp.add(sub);
                findSolution(s, i+1, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String temp) {
        int i=0, j=temp.length()-1;
        while(i<j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
