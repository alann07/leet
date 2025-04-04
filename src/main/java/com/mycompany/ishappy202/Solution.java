package com.mycompany.ishappy202;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * 1ms Beats 63.34%, 40.93MB Beats 38.20%
 */
public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        int sum = 0;
        int numToProcess = n;
        int remainder;
        Map<Integer, Boolean> visited = new HashMap<>();
        visited.put(n, true);
        while(true) {
            while(numToProcess>0) {
                remainder = numToProcess % 10;
                numToProcess = numToProcess / 10;
                sum += remainder * remainder;
            }
            if (sum == 1) return true;
            if (visited.get(sum) != null) return false;
            visited.put(sum, true);
            numToProcess = sum;
            sum = 0;
        }
    }
}
