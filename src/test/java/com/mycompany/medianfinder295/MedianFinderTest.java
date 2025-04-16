package com.mycompany.medianfinder295;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianFinderTest {
    @Test
    public void testMedianFinder() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(2);
        mf.addNum(3);
        assertEquals(2.5, mf.findMedian());
        mf.addNum(4);
        assertEquals(3, mf.findMedian());
    }
}
