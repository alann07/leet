package com.mycompany.getmaxlen1567;

/**
 * 1567. Maximum Length of Subarray With Positive Product
 * Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
 *
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 *
 * Return the maximum length of a subarray with positive product.
 *
 * Smart idea to count just negative numbers.
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/solutions/819278/java-o-n-time-o-1-space/
 * 1 interation, O(n)
 * 3ms Beats 99.09%, 60.23MB Beats 64.55%
 */
public class ImprovedSolution {
    public int getMaxLen(int[] nums) {
        // sum is used to count the number of negative numbers from zeroPosition to current index
        int firstNegative = -1, zeroPosition = -1, sum = 0, max = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] < 0){
                sum++;
                // we only need to know index of first negative number
                if(firstNegative == -1) firstNegative = i;
            }
            // if current number is 0, we can't use any element from index 0 to i anymore, so update zeroPosition,
            // and reset sum and firstNegative. If it is a game, we should refresh the game when we meet 0.
            if(nums[i] == 0){
                sum = 0;
                firstNegative = -1;
                zeroPosition = i;
            }
            else{
                // consider index of zero
                if(sum%2 == 0) max = Math.max(i - zeroPosition, max);
                // consider index of first negative number
                else max = Math.max(i - firstNegative, max);
            }
        }
        return max;
    }
}
