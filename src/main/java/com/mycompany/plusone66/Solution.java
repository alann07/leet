package com.mycompany.plusone66;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit
 * of the integer. The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * 0ms Beats 100.00%, 42.08MB Beats 30.09%
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        int carry = 0;
        for (int i=digits.length-1; i>=0; i--) {
            carry =+ carry + (i==digits.length-1? 1: 0) + digits[i];
            digits[i] = carry % 10;
            carry = carry / 10;
        }
        if (carry == 1) {
            int[] newArry = new int[digits.length + 1];
            newArry[0] = 1;
            for (int i=0; i< digits.length; i++) {
                newArry[i+1] = digits[i];
            }
            return newArry;
        } else {
            return digits;
        }
    }
}
