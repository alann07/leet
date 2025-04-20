package com.mycompany.maxprofit121;

// 2ms Beats 74.91% 62.43MB Beats 6.79% (without max variable, which can sav processing)
// 1ms Beats 99.85%61.47 MB Beats 81.37% (after adding a max variable)
public class ImprovedSolution {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        int max = -1;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
//                max = min;
            } else {
                if (prices[i] >= max && prices[i] - min > result) {
                    result = prices[i] -min;
                    max = prices[i];
                }
            }
        }

        return result;
    }
}
