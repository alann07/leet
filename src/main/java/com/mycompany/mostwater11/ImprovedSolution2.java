package com.mycompany.mostwater11;

public class ImprovedSolution2 {

    // 3ms beats 96.36%, mem beat 64.36%
    public int maxArea(int[] height) {
        if (height == null || height.length <2 || height.length>100000)
            throw new RuntimeException("wrong range");

        int max = 0;
        int left = 0;
        int right = height.length-1;
        int rightMax=0;
        int leftMax=0;

        while (left < right) {
            int area = (right - left) * min(height[left], height[right]);
            max = max(max, area);
            if (height[left] < height[right]) {
                leftMax = height[left];
                left++;
                while(left<=right && height[left]<=leftMax) {
                    left++;
                }
            } else {
                rightMax = height[right];
                right--;
                while(right>=left && height[right]<=rightMax) {
                    right--;
                }
            }
        }

        return max;
    }

    int min(int a, int b) {
        return a<b?a:b;
    }

    int max(int a, int b) {
        return a>b?a:b;
    }
}
