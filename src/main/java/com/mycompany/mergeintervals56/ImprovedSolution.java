package com.mycompany.mergeintervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * I didn't add int[] directly to the List. Changing to it saves both time and space.
 * 9ms Beats 49.03%, 46.65MB Beats 54.74%
 *
 * btw, using ArrayList.toArray is slower than direct allocation a new array and assign.
 */
public class ImprovedSolution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> results = new ArrayList<>();

        int[] prev = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];

            if (curr[0]>prev[1]) {
                results.add(prev);
                prev = curr;
            } else {
                if (curr[1]>prev[1])
                    prev[1] = curr[1];
            }
        }
        results.add(prev);

        int[][] arrayResult = new int[results.size()][2];
        for(int i=0; i<results.size(); i++) {
            arrayResult[i] = results.get(i);
        }
        return arrayResult;
    }
}
