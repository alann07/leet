package com.mycompany.maxprofit122;

// dp without memorization. (was confused by its example "sell on day 5 (price = 5), profit = 5-1 = 4.". Thought
// target will have higher value at later time, which makes things complicated.
// 0ms Beats 100.00%, 46.36MB Beats 12.38%
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        return findSolution(prices, 1);
    }

    private int findSolution(int[] prices, int index) {

        if (index > prices.length-1) return 0;

        int result = 0;
        int i=index;
        boolean triggered = false;
        while(!triggered && i < prices.length) {

            if (prices[i] > prices[i-1]) {
                result += prices[i] - prices[i-1] + findSolution(prices, i + 1);
                triggered = true;
            }
            i++;
        }

        return result;
    }

//    private int findSolution2(int[] prices, int targetIndex, int subArrayIndex) {
//
//        if (targetIndex > prices.length-1 || subArrayIndex > prices.length-1) return 0;
//
//        int result = 0;
//        int i=subArrayIndex;
//        boolean ignoreTarget = false;
//        while(i < prices.length) {
//
//            if (!ignoreTarget && prices[i] > prices[targetIndex]) {
//                int option1 = prices[i] - prices[targetIndex] + findSolution(prices, i+1,i+2);
//                int option2 = findSolution(prices, targetIndex, i+1);
//                result += Math.max(option1, option2);
//                break;
//            } else if (prices[i] > prices[i-1]) {
//                int option1 = prices[i] - prices[i-1] + findSolution(prices, i+1,i+2);
//                int option2 = findSolution(prices, i-1, i+1);
//                result += Math.max(option1, option2);
//                ignoreTarget = true;
//            }
//            if (ignoreTarget) break;
//            i++;
//        }
//
//        return result;
//    }
}
