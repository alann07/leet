package com.mycompany.palindrome131;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Wrong understanding of partition. i used the fixed partition, but in fact, it should be changeable for each iteration
 * and hence using backtrack recursion.
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length()<1) return result;

        findSolution(s, 0, result);
        return result;
    }

    private void findSolution(String s, int index, List<List<String>> result) {
        for (int partition = 1; partition<=s.length(); partition++) {

            List<String> subResult = new ArrayList<>();
            for (int i = index; i < s.length(); i++) {
                String sub;
                if (i+partition<s.length()) {
                    sub = s.substring(i, i + partition);
                } else {
                    sub = s.substring(i);
                }
                if (isPalindrome(sub)) {
                    subResult.add(sub);
                }
                if (partition==s.length()) {
                    break;
                }
            }

            if (!subResult.isEmpty()) {
                result.add(subResult);
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
