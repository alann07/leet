package com.mycompany;

import org.junit.jupiter.api.Test;

public class GfgTest {

    @Test
    public void testAlreadySorted() {
        int[] arr = {2,5,5,11};
        GfG.quickSort(arr, 0, arr.length - 1);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
