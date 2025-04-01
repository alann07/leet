package com.mycompany.trie208;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve
 * keys in a dataset of strings. There are various applications of this data structure, such as autocomplete
 * and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and
 * false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the
 * prefix, and false otherwise.
 *
 * 41ms Beats 32.10%, 55.46MB Beats 56.35%
 */
public class TrieFirstVersion {
    TrieNode root;

    public TrieFirstVersion() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if (curr.getChildren()[getOrdinal(c)] == null) {
                curr.getChildren()[getOrdinal(c)] = new TrieNode(c);
            }
            if (i==word.length()-1) {
                curr.getChildren()[getOrdinal(c)].isEnd = true;
                break;
            }
            curr = curr.getChildren()[getOrdinal(c)];
        }
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.getChildren()[getOrdinal(c)] == null)  return false;
            if (i==word.length()-1 && !curr.isEnd) return false;
            curr = curr.getChildren()[getOrdinal(c)];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        TrieNode curr = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.getChildren()[getOrdinal(c)] == null)  return false;
            curr = curr.getChildren()[getOrdinal(c)];
        }
        return true;
    }

    int getOrdinal(char c) {
        return c - 'a';
    }

    public class TrieNode {
        char val;
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {}
        TrieNode(char val) { this.val = val; }
        public TrieNode[] getChildren() {
            if (children == null) {
                children = new TrieNode[26];
            }
            return  children;
        }
    }
}
