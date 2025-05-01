package com.mycompany.maxpoints149;

import java.util.*;

/**
 * 149. Max Points on a Line
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum
 * number of points that lie on the same straight line.
 *
 * GCD: greatest common divisor
 * int getGcd(const int a, const int b)
 *     {
 *         if(a==0) return b;
 *         return getGcd(b%a, a);
 *     }
 *
 * In this solution, a PointAttribute object is used as key for the hashset. Its equals() and hashCode() are
 * overriden to use value only.
 * 29ms Beats 42.55%, 55.74MB Beats 5.28%
 */
public class ImprovedSolution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Map<PointAttribute, HashSet<int[]>> slantLines = new HashMap<>();
        Map<Integer, HashSet<int[]>> horizontalLines = new HashMap<>();
        Map<Integer, HashSet<int[]>> VerticalLines = new HashMap<>();

        HashSet<int[]> val;
        for (int i=0; i<points.length; i++) {
            for (int j=i+1; j<points.length; j++) {
                int x1 = points[j][0], y1 = points[j][1];
                int x2 = points[i][0], y2 = points[i][1];
                if (x1 == x2) {
                    val = VerticalLines.computeIfAbsent(x1, k -> new HashSet<>());
                    val.add(points[i]);
                    val.add(points[j]);
                } else if (y1 == y2) {
                    val = horizontalLines.computeIfAbsent(y1, k -> new HashSet<>());
                    val.add(points[i]);
                    val.add(points[j]);
                } else {
                    double slantVal = (double) (y2 - y1) / (x2-x1);
                    double a = y1 - slantVal * x1;
                    PointAttribute key = new PointAttribute(a, slantVal);
                    val = slantLines.computeIfAbsent(key, k -> new HashSet<>());
                    val.add(points[i]);
                    val.add(points[j]);
                }
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

    public class PointAttribute{
        double a, slantRate;
        public PointAttribute(double a, double slantRate) {
            this.a = a;
            this.slantRate = slantRate;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PointAttribute that)) return false;
            return Double.compare(a, that.a) == 0 && Double.compare(slantRate, that.slantRate) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, slantRate);
        }
    }
}
