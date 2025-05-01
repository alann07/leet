package com.mycompany.rotatearray189;

/**
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * A genious idea from forum discussion.
 * https://leetcode.com/problems/rotate-array/submissions/1623136773/?envType=study-plan-v2&envId=top-interview-150
 * 0ms Beats 100.00%, 57.66MB Beats22.71%
 */
public class ImprovedSolution2 {
    public void rotate(int[]nums,int k){
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[]nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
