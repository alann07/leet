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
 * 3ms Beats 17.94%, 41.85MB Beats 30.10%
 */
public class ImprovedSolution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = citations.length;
        int hi = n, i = 0;

        while(i< n && citations[i] < hi ) {
            hi--;
            i++;
        }

        return hi;
    }
}
