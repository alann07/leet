package com.mycompany.maxpoints149;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum
 * number of points that lie on the same straight line.
 *
 * Brute force approach: count vertical/horizontal/slant lines.
 * Use a set to store all the points to remove duplicate points count in a line.
 * Then we just check, for the same line, how many points is collected in each size and get the max.
 *
 * The above is wrong and it didn't include starting point, which, together with slant rate, determines
 * the line. Hence, it's wrong solution. (y = a + bx)
 */
public class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Map<Double, HashSet<int[]>> slantLines = new HashMap<>();
        Map<Integer, HashSet<int[]>> horizontalLines = new HashMap<>();
        Map<Integer, HashSet<int[]>> VerticalLines = new HashMap<>();

        HashSet<int[]> val;
        for (int i=0; i<points.length; i++) {
            for (int j=i+1; j<points.length; j++) {
                int x1 = points[j][0], y1 = points[j][1];
                int x2 = points[i][0], y2 = points[i][1];
                if (x1 == x2) {
                    val = VerticalLines.get(x1);
                    if (val == null) { val = new HashSet<>(); VerticalLines.put(x1, val); }
                    val.add(points[i]);
                    val.add(points[j]);
                } else if (y1 == y2) {
                    val = horizontalLines.get(y1);
                    if (val == null) {val = new HashSet<>(); horizontalLines.put(y1, val); }
                    val.add(points[i]);
                    val.add(points[j]);
                } else {
                    double slantVal = (double) (y2 - y1) / (x2-x1);
                    val = slantLines.get(slantVal);
                    if (val == null) {val = new HashSet<>(); slantLines.put(slantVal, val); }
                    val.add(points[i]);
                    val.add(points[j]);                }
            }
        }
        int max = -1;
        max = Math.max(checkMaxPoints(slantLines.values()), checkMaxPoints(horizontalLines.values()));
        max = Math.max(max, checkMaxPoints(VerticalLines.values()));

        return max;
    }

    private int checkMaxPoints(Collection<HashSet<int[]>> values) {
        int max = -1;
        for(HashSet<int[]> value: values) {
            max = Math.max(max, value.size());
        }
        return max;
    }
}
