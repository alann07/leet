package com.mycompany.maxsubarraysumcircular918;

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of
 * nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i],
 * nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 * Approach: based on max Subarray #53, add circular. Performance is slow.
 * 2371ms Beats 5.96%, 48.90MB Beats 92.62%
 * 875ms Beats 6.00%, 49.96MB Beats 7.31%
 */
public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int currMax = -100000;
        int maxSoFar = -100000;
        int currSubSize = 0;
        int index = 0;
        boolean[] visited = new boolean[n];
        while (index < n) {
            if (visited[index]) {
                index ++;
                continue;
            }
            for (int i = index; i < n * 2; i++) {
                if (i-index > n) break;
                if (currMax + nums[i % n] > nums[i % n]) {
                    currMax = currMax + nums[i % n];
                    currSubSize++;

                } else {
                    currMax = nums[i % n];
                    currSubSize = 1;
                    if (i<n) {
                        index = i;
                        visited[index] = true;
                    }
                }
                maxSoFar = Math.max(currMax, maxSoFar);
                if (currSubSize == n) {
                    currSubSize = 0;
                    currMax = -100000;
                    break;
                }
            }
            if (index>n-1 && nums[index+1] > nums[index]) {
                index++;
            } else {
                index += 2;
                currSubSize = 0;
                currMax = -100000;
            }
        }
        return maxSoFar;
    }
}
