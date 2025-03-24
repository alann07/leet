package com.mycompany.longestsubstringnorepeat3;

public class ReviewSolution4 {

    //  6ms. using sliding window reduces a lot more coding than previous solutions,
    //  but performance is not as good.
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int length = s.length();
        if (length <= 0 || length > 50000) return 0;
        if (length == 1) return 1;

        // treat the first element as 1 count, as the loop start with the 2nd element.
        int start = 0, maxLen = 1, currIndex = 1;
        char currChar;

        while (true) {
            currChar = s.charAt(currIndex);
            while (indexOfFirstOccrence(s, currChar, start, currIndex) == -1){
                if (currIndex-start+1 > maxLen) maxLen = currIndex-start+1;
                currIndex++;
                if (currIndex < length) {
                    currChar = s.charAt(currIndex);
                } else return maxLen;
            }
            start++;
        }
//        return maxLen;
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
