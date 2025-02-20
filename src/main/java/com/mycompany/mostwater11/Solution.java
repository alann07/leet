package com.mycompany.mostwater11;

public class Solution {

    // 6ms beats 7.14%, mem beat 64%
    public int maxArea(int[] height) {
        if (height == null || height.length <2 || height.length>100000)
            throw new RuntimeException("wrong range");

        int max = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
