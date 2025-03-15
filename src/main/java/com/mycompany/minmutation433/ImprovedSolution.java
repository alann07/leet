package com.mycompany.minmutation433;

import java.util.*;

/**
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 * Below trie solution does not work. BFS definitely does not fit here. Searching character by character seems wrong
 * direction. It does not distinguish level vs vertical. Using DFS is more appropriate, but it will involve how to distinguish
 * explored vs not explored.
 *
 * Referencing the C++ solution from the forum, which replaces char and add into the queue, which is a true BFS
 * 1ms Beats 81.64%, 41.26MB Beats 91.71%
 */
public class ImprovedSolution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean endGeneExist = false;
        for (String string : bank) {
            if (endGene.equals(string)) {
                endGeneExist = true;
                break;
            }
        }
        if (!endGeneExist) return -1;

        Set<String> set = new HashSet<>();
        set.addAll(List.of(bank));

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return steps;
                set.remove(curr);
                for (int i=0; i<curr.length(); i++) {
                    StringBuilder sb = new StringBuilder(curr);
                    char c = sb.charAt(i);
                    if ( c!='A') {
                        sb.setCharAt(i, 'A');
                        if (set.contains(sb.toString())) {
                            queue.add(sb.toString());
                        }
                    }
                    if ( c!='C') {
                        sb.setCharAt(i, 'C');
                        if (set.contains(sb.toString())) {
                            queue.add(sb.toString());
                        }
                    }
                    if ( c!='G') {
                        sb.setCharAt(i, 'G');
                        if (set.contains(sb.toString())) {
                            queue.add(sb.toString());
                        }
                    }
                    if ( c!='T') {
                        sb.setCharAt(i, 'T');
                        if (set.contains(sb.toString())) {
                            queue.add(sb.toString());
                        }
                    }
                }
            }
            steps ++;
        }
        return -1;
    }
}
