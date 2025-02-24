package com.mycompany.maxenergy3147;

import java.util.HashMap;
import java.util.Map;

// 29ms Beats 13.28%
public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        Integer result = null;
        int key;
        Integer val;
        Map<Integer, Integer> store = new HashMap<>();
        for (int i=0; i<energy.length; i++) {
            key = i % k;
            val = store.get(key);
            if (val == null) {
                val = energy[i];
            } else {
                val += energy[i];
            }
            int subMax = Math.max(val, energy[i]);

            if (i>=energy.length-k) {
                if (result == null) result = subMax;
                else result = Math.max(result, subMax);
            } else {
                store.put(key, subMax);
            }
        }
        return result;
    }
}
