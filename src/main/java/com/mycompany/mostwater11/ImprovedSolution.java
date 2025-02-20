package com.mycompany.mostwater11;

public class ImprovedSolution {

    // 3ms beats 96.36%, mem 57.59 beat 81.36%
    public int maxArea(int[] height) {
        if (height == null || height.length <2 || height.length>100000)
            throw new RuntimeException("wrong range");

        int max = 0;
        int left = 0;
        int right = height.length-1;
        int rightMax=0;
        int leftMax=0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                leftMax = height[left];
                left++;
                while(left<right && height[left]<=leftMax) {
                    left++;
                }
            } else {
                rightMax = height[right];
                right--;
                while(right>left && height[right]<=rightMax) {
                    right--;
                }
            }
        }

        return max;
    }
}
