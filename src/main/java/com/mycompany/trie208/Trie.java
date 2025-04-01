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
 * Approach: no need to store "c" in TrieNode, as index already represent the char.
 * Btw, init children in constructor costs more time, as some TrieNode doesn't need to have any children.
 * So only instantiate it when used.
 * 38ms Beats 44.55%, 55.58MB Beats 44.60%
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        int index;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            index = c - 'a';
            if (curr.getChild(index) == null) {
                curr.setChild(index);
            }
            curr = curr.getChild(index);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        TrieNode curr = root;
        int index;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            index = c - 'a';
            if (curr.getChild(index) == null)  return false;
            curr = curr.getChild(index);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        TrieNode curr = root;
        int index;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            index = c - 'a';
            if (curr.getChild(index) == null)  return false;
            curr = curr.getChild(index);
        }
        return true;
    }

    public class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode getChild(int index) {
            if (children == null) {
                children = new TrieNode[26];
            }
            return  children[index];
        }
        public void setChild(int index) {
            children[index] = new TrieNode();
        }
    }
}
