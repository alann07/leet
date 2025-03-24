package com.mycompany.longestsubstringnorepeat3;

public class ImprovedSolution3 {

    //  2 ms. Beat 98.54%.  42.81 MB, beat 98.67%.
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

            int start = currIndex-currSubLength;
            firstOccurIndex = indexOfFirstOccrence(s, c, start, currIndex);
            if (firstOccurIndex >=0) {
                if (currSubLength > maxLength) {
                    maxLength = currSubLength;
                }
                currSubLength =  currSubLength - (firstOccurIndex - start + 1) + 1;
            } else {
                currSubLength++;
            }
            currIndex++;

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
