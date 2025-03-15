package com.mycompany.minmutation433;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 */
public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean found = false;
        for (String string : bank) {
            if (endGene.equals(string)) {
                found = true;
                break;
            }
        }
        if (!found) return 0;

        Trie trie = new Trie();
        for (String s : bank) {
            trie.insert(s);
        }

        List<List<String>> store = new ArrayList<>();
        List<String> pathStore = new ArrayList<>();
        bfs(startGene, endGene, trie, store, pathStore, new StringBuilder());

        if (store.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for(List<String> path: store) {
            min = Math.min(min, path.size());
        }
        return min;
    }

    private void bfs(String startGene, String endGene, Trie trie, List<List<String>> allPaths,
                     List<String> pathStore, StringBuilder temp) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(trie.root);
        while(!queue.isEmpty()) {
            TrieNode curr = queue.poll();
            char c = curr.val;
            // this only applies to root.
            if ( c != '\u0000') {
                temp.append(c);
            } else {
                for (TrieNode node : curr.getChildren()) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
                continue;
            }
            if (temp.toString().equals(endGene)) {
                pathStore.add(temp.toString());
                allPaths.add(new ArrayList<>(pathStore));
                return;
            } else {
                if (has2Mutations(temp, startGene)) {
                    // remove the last char from temp
                    temp.deleteCharAt(temp.length()-1);
                } else {
                    // continue the rest
                    if (!curr.isEnd) {
                        for (TrieNode node : curr.getChildren()) {
                            if (node != null) {
                                queue.add(node);
                            }
                        }
                    } else {
                        pathStore.add(temp.toString());
                        bfs(temp.toString(), endGene, trie, allPaths, pathStore, new StringBuilder());
                    }
                }
            }
        }
    }

    private boolean has2Mutations(StringBuilder temp, String startGene) {
        int count = 0;
        for (int i=0; i<temp.length(); i++) {
            if (temp.charAt(i) != startGene.charAt(i)) {
                count ++;
            }
        }

        return count > 1;
    }

    public class TrieNode {
        char val;
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {}
        TrieNode(char val) { this.val = val; }
        public TrieNode[] getChildren() {
            if (children == null) {
                children = new TrieNode[4];
            }
            return  children;
        }
    }

    public class Trie {
        TrieNode root;
        Trie() {root = new TrieNode();}
        void insert(String mutation) {
            TrieNode curr = root;
            for (int i=0; i<mutation.length(); i++) {
                char c = mutation.charAt(i);
                if (curr.getChildren()[getOrdinal(c)] == null) {
                    curr.getChildren()[getOrdinal(c)] = new TrieNode(c);
                    if (i==mutation.length()-1) {
                        curr.getChildren()[getOrdinal(c)].isEnd = true;
                        break;
                    }
                }

                curr = curr.getChildren()[getOrdinal(c)];
            }
        }

        int getOrdinal(char c) {
            if (c == 'A') {
                return 0;
            } else if (c == 'C') {
                return 1;
            } else if (c == 'G') {
                return 2;
            } else {
                return 3;
            }
        }
    }
}
