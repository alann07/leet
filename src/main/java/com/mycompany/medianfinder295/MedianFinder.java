package com.mycompany.medianfinder295;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is
 * no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual
 * answer will be accepted.
 *
 * https://www.youtube.com/watch?app=desktop&v=SdURPlHqc1g&t=178
 * 111ms Beats 45.06%, 63.80 MB Beats 57.31%
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean even = true;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (even) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        even = !even;
    }

    public double findMedian() {
        return even ? (double) (maxHeap.peek() + minHeap.peek()) / 2 : minHeap.peek();
    }
}