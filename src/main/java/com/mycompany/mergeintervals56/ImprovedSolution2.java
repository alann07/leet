package com.mycompany.mergeintervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * One more attempt. Try sliding window. Not faster, but more space efficient.
 * 11ms Beats 13.39%, 46.33MB Beats 91.60%
 *
 */
public class ImprovedSolution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> results = new ArrayList<>();

        int[] curr;
        int j;
        for (int i=0; i<intervals.length; i++) {
            j = 1;
            curr = intervals[i];
            while(i+j<intervals.length && intervals[i+j][0]<=curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i+j][1]);
                j++;
            }
            i += j-1;
            results.add(curr);
        }

        int[][] arrayResult = new int[results.size()][2];
        for(int i=0; i<results.size(); i++) {
            arrayResult[i] = results.get(i);
        }
        return arrayResult;
    }
}
