package com.mycompany.rotatearray189;

/**
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * 2ms Beats 28.52%, 57.45B Beats 51.80%
 */
public class ImprovedSolution {
    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        int n = nums.length;;
        if ( n == 1 || k%n == 0) return;
        k %= n;
        int[] prev = new int[k];
        for (int i=0; i<k; i++) {
            prev[i] = nums[i];
        }
        int i = k, tmp, count= n, p=0;
        while (count>0) {
            tmp = nums[i];
            nums[i] = prev[p];
            prev[p] = tmp;

            p = (p+1)%k;

            i++;
            if (i>n-1) i=0;
            count--;
        }
    }
}
