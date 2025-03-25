package com.mycompany.mergeintervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * 189ms Beats 5.43%, 47.08MB Beats 10.14% (sorting first).
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<List<Integer>> results = new ArrayList<>();

        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        int currStart, currEnd;
        for (int i=1; i<intervals.length; i++) {
            currStart = intervals[i][0];
            currEnd = intervals[i][1];
            if (currStart>preEnd) {
                List<Integer> temp = new ArrayList<>();
                temp.add(preStart);
                temp.add(preEnd);
                results.add(temp);

                preStart = currStart;
                preEnd = currEnd;
            } else {
                if (currEnd > preEnd) {
                    preEnd = currEnd;
                }
            }
            if (i== intervals.length-1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(preStart);
                temp.add(preEnd);
                results.add(temp);
            }
        }
        int[][] arrayResult = new int[results.size()][2];
        for(int i=0; i<results.size(); i++) {
            arrayResult[i][0] = results.get(i).get(0);
            arrayResult[i][1] = results.get(i).get(1);
        }
        return arrayResult;
    }
}
