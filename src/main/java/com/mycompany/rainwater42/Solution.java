package com.mycompany.rainwater42;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * https://leetcode.com/problems/trapping-rain-water/solutions/4158470/3-lines-solution-with-explaination/
 * https://leetcode.com/problems/trapping-rain-water/solutions/5010283/3-easy-interview-approach-brute-force-two-pointer-s-monotonic-stack-dry-run/
 *
 * 1ms Beats 63.17%, 46.80MB Beats 13.69%
 *
 * My own approach is more complicated. I need to find all the waves and add them together. A bit painful.
 */
public class Solution {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
        }
        return ans;
    }

//    public int trap(int[] height) {
//        int n = height.length;
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//
//        // Prefix calculation
//        leftMax[0] = 0;
//        for (int i = 1; i < n; ++i) {
//            leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
//        }
//
//        // Suffix calculation
//        rightMax[n - 1] = 0;
//        for (int i = n - 2; i >= 0; --i) {
//            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
//        }
//
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            int waterLevel = Math.min(leftMax[i], rightMax[i]);
//            if (waterLevel >= height[i]) ans += waterLevel - height[i];
//        }
//        return ans;
//    }
}

