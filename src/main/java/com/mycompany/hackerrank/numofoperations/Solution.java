package com.mycompany.hackerrank.numofoperations;

/**
 * From Blue Origin
 * Example
 * Given, s = "abb".
 * Transform the queue to abcab by inserting two letters c, and one letter a. The string
 * "abcabc" is the concatenation of "abc" two times.
 * The minimum number of scheduling operations required is 3.
 * Function Description
 * Complete the function findMinOperations in the editor below.
 * findMinOperations takes the following parameters:
 * string s: the scheduling queue
 * Returns
 * int: the minimum number of operations required to make the queue a concatenation of 'abc several times
 */
public class Solution {
    public int findMinOperations (String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 2;

        char prev=s.charAt(0), curr;
        int counter = 0;
        if (prev == 'b') counter += 1;
        else if (prev == 'c') counter += 2;
        for (int i=1; i<s.length(); i++) {
            curr = s. charAt(i);
            counter+= numofOps(prev, curr);
            prev = curr;
        }
        if (s.charAt(s.length()-1) == 'a') counter +=2;
        else if (s.charAt(s.length()-1) == 'b') counter++;
        return counter;
    }

    private int numofOps (char prev, char curr) {
        if (curr == prev) return 2;
        else if (curr > prev) return curr - prev -1;
        else return Math.abs(prev - curr - 2);
    }
}
