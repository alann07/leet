package com.mycompany.maxprofit123;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[][] maxProfits = new int[prices.length][2];
        findSolution(prices, 0, 0, maxProfits);
        int max = 0;
        for (int i=0; i<maxProfits[0].length; i++) {
            int currMax = maxProfits[i][0]+maxProfits[i][1];
            if (currMax > max) {
                max = currMax;
            }
        }
        return max;
    }

    private void findSolution(int[] prices, int index, int rowTarget, int[][] maxProfits) {

        if (index > prices.length-1) return;

        boolean foundFirst;
        for (int i=index; i<prices.length; i++) {
            foundFirst = false;
            for (int j=i+1; j<prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > 0) {
                    foundFirst = true;
                    if (!targetRowHasRecords(rowTarget, maxProfits)) {
                        findSolution(prices, j, i, maxProfits);
                    }

                    updateProfitRecords(maxProfits, rowTarget, profit);
                    if (rowTarget != i) {
                        updateProfitRecords(maxProfits, i, profit);
                    }
                }
                if (foundFirst) {
                    // jump to next i.
                    rowTarget ++;
                    break;
                }
                // at the end of each j, need to compare results with previous j and decide which is bigger.

            }
        }

    }

    private boolean targetRowHasRecords(int rowTarget, int[][] maxProfits) {
        return maxProfits[rowTarget][0] > 0 || maxProfits[rowTarget][1] > 0;
    }

    private void updateProfitRecords(int[][] maxProfits, int rowIndex, int profit) {
        if (profit > maxProfits[rowIndex][0] && profit > maxProfits[rowIndex][1]) {
            maxProfits[rowIndex][0] = maxProfits[rowIndex][1];
            maxProfits[rowIndex][1] = profit;
        } else {
            if (profit > maxProfits[rowIndex][0]) {
                maxProfits[rowIndex][0] = profit;
            }
        }
    }
}
