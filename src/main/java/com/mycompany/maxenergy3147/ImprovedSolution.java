package com.mycompany.maxenergy3147;

import java.util.HashMap;
import java.util.Map;

// 2ms Beats 98.43%, 61.26MB Beats 62.99%
public class ImprovedSolution {
    public int maximumEnergy(int[] energy, int k) {
        int result = Integer.MIN_VALUE;
        int[] store = new int[energy.length];
        for (int i=0; i<energy.length; i++) {
            int subMax = Math.max(energy[i] + (i>=k? store[i-k]: 0), energy[i]);
            store[i] = subMax;
            if (i>=energy.length-k) {
                result = Math.max(result, subMax);
            }
        }
        return result;
    }
}
