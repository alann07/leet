package com.mycompany.longestcommonprefix14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * 1ms beats 65.31%, 41.81MB Beats 32.97%
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length==1) return strs[0];
        int j=0;
        char curr = 0;
        while(true) {

            for (int i=0; i<strs.length; i++) {
                if (strs[i].length() == j) return strs[0].substring(0,j);
                if (i == 0) curr = strs[i].charAt(j);
                else if (strs[i].charAt(j) != curr) {
                    return strs[0].substring(0,j);
                }
            }
            j++;
        }
    }
}
