package com.mycompany.longestsubstringnorepeat;

public class ImprovedSolution {

    // 129 ms
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

            firstOccurIndex = s.indexOf(c, currIndex-currSubLength);
            if (firstOccurIndex >=0 && firstOccurIndex < currIndex) {
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
}
