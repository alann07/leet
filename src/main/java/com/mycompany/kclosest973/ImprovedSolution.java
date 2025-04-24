package com.mycompany.kclosest973;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 * MinHeap, with just k elements, distance is minus, so that pop can pop the actual longer distance point.
 * However, this approach is slower than the previous, 36ms, and cost more space.
 */
public class ImprovedSolution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k > points.length) return null;
        PriorityQueue<Point> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a.val));
        Point p;
        for (int i=0; i< points.length; i++) {
            p = new Point(points[i][0], points[i][1],
                    -points[i][0] * points[i][0] - points[i][1] * points[i][1]);
            minHeap.offer(p);
            if (minHeap.size() > k) minHeap.poll();
        }
        int[][] results = new int[k][2];
        int i=0;
        while (i<k) {
            p = minHeap.poll();
            results[i][0] = p.x;
            results[i][1] = p.y;
            i++;
        }
        return results;
    }

    public class Point {
        int val;
        int x, y;
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.val = distance;
        }
    }
}
