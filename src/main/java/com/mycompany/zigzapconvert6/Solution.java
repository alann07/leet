package com.mycompany.zigzapconvert6;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * 1st try: key is col += n-1. Pre-allocated array with s.length.
 * 45ms Beats 6.83%, 55.53MB Beats 5.03%
 *
 * 2nd try: reduce pre-allocated array col size to be s.length() <=3 ? s.length() : s.length()/2 + 1. It helps.
 * 25ms Beats 10.75%
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows<=1 || s.length() <= numRows) return s;

        int colSize = s.length() <= 3 ? s.length() : s.length() / 2 + 1;
//      int colSize = s.length() / numRows + (s.length() - s.length() / numRows) + 1;


        Character[][] charArray = new Character[numRows][colSize];
        int count = 0, col = 0;
        while (count<s.length()) {
            for (int i=0; i<numRows; i++) {
                charArray[i][col] = s.charAt(count++);
                if (count == s.length()) break;
            }
            if (count < s.length()) {
                col += numRows - 1;
                for (int i = numRows - 2; i > 0; i--) {
                    charArray[i][col - i] = s.charAt(count++);
                    if (count == s.length()) break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i< charArray.length; i++) {
            for (int j=0; j< charArray[0].length; j++) {
                Character c = charArray[i][j];
                if (c != null) sb.append(c);
            }
        }
        return sb.toString();
    }


//    public String convert(String s, int numRows) {
//        if(numRows==1) return s;
//        int n = s.length();
//        char[][] mat = new char[numRows][n];
//        int k=0;
//        int i=0, j=0;
//        boolean down = true;
//        while(k<n) {
//            mat[i][j] = s.charAt(k);
//            if(i==numRows-1) down = false;
//            if(i==0) down = true;
//            if(down) {
//                i++;
//            } else {
//                i--;
//                j++;
//            }
//            k++;
//        }
//        StringBuilder res = new StringBuilder();
//        for(i=0;i<numRows;i++) {
//            for(j=0;j<n;j++) {
//                if(mat[i][j]!='\u0000') {
//                    res.append(mat[i][j]);
//                }
//            }
//        }
//        return res.toString();
//    }
}



