package com.mycompany.lrucache146;

import java.util.*;

/**
 * 146. LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise,
 * add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * 42ms Beats 93.34%, 112.04MB Beats 86.83%
 */
public class LRUCache {
    private final Map<Integer, Node> lru = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = lru.get(key);
        if (node == null) return -1;
        removeNodeFromList(node);
        insertAtHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = lru.get(key);
        if (node == null) {
            if (size == capacity) {
                int removedKey = removeOneFromTail();
                lru.remove(removedKey);
            }
            node = new Node(key, value);
            size++;
        } else {
            node.val = value;
            removeNodeFromList(node);
        }
        insertAtHead(node);
        lru.put(key, node);
    }

    private int removeOneFromTail() {
        Node temp = tail.prev;
        temp.prev.next = tail;
        tail.prev = temp.prev;
        size--;
        return temp.key;
    }

    private void removeNodeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    class Node {
        Node prev = null, next = null;
        int key, val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
