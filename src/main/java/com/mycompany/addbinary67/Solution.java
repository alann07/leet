package com.mycompany.addbinary67;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * 2ms Beats 45.02%, 42.18MB Beats 81.55%
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a== null || a.isEmpty() || b==null || b.isEmpty()) return null;

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        char aa, bb, add='0';

        while(i>=0 || j>=0) {
            if (i>=0) {
                aa = a.charAt(i);
                i--;
            } else {
                aa = '0';
            }
            if (j>=0) {
                bb = b.charAt(j);
                j--;
            } else {
                bb = '0';
            }

            if ( aa == '1' && bb == '1') {
                sb.insert(0, add == '1' ? '1' : '0');
                add = '1';
            } else if (aa == '0' && bb == '0') {
                if (add == '1') {
                    sb.insert(0, '1');
                    add = '0';
                } else {
                    sb.insert(0, '0');
                }
            } else {
                if (add == '1') {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                    add = '0';
                }
            }
        }
        if (add == '1') {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
