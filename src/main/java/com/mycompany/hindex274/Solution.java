package com.mycompany.hindex274;

import java.util.Arrays;

/**
 * 274. H-Index
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their
 * ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that
 * the given researcher has published at least h papers that have each been cited at least h times.
 *
 * O(nxn) is slow.
 * 5ms Beats 9.67%, 41.67 MB Beats 52.63%
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int hi = 0, tgt=1;
        Arrays.sort(citations);
        int i = 0, hcount = 0;

        while(true) {
            i = 0;
            while (i < citations.length) {
                if (citations[i] >= tgt) {
                    hcount++;
                    if (hcount == tgt) {
                        hi = tgt;
                        hcount = 0;
                        break;
                    }
                }
                i++;
            }
            tgt++;
            if (i== citations.length) break;
        }

        return hi;
    }
}
