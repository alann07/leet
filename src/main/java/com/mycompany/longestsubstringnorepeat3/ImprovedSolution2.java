package com.mycompany.longestsubstringnorepeat3;

public class ImprovedSolution2 {

    //  206 ms. worst
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int length = s.length();
        if (length <= 0 || length > 50000) return 0;
        if (length == 1) return 1;

        int maxLength = 1;
        int currSubLength = 1;
        int currIndex = 1;
        int firstOccurIndex = 0;

        while (true) {
            char c = s.charAt(currIndex);

            firstOccurIndex = indexOfFirstOccrence(s, c,currIndex-currSubLength, currIndex);
            if (firstOccurIndex >=0) {
                if (currSubLength > maxLength) {
                    maxLength = currSubLength;
                }
                currIndex = firstOccurIndex + 1;
                if (maxLength > length-currIndex-1) break;

                currSubLength = 0;
            } else {
                currSubLength++;
                currIndex++;
            }

            if (currIndex == length) {
                if (currSubLength > maxLength) {
                    maxLength = currSubLength;
                }
                break;
            }
        }
        return maxLength;
    }

    private int indexOfFirstOccrence(String s, char c, int start, int end) {
        for (int i=start; i<end; i++) {
            if (c == s.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
