package com.mycompany.copyrandomlist138;

/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node. Both the
 * next and random pointer of the new nodes should point to new nodes in the copied list such that
 * the pointers in the original list and copied list represent the same list state. None of the pointers
 * in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the
 * corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * Used a brute force solution, i.e, build the new linkedList for "next" first. then iterate each original node (and new
 * list node) and see if random node exists. If yes, assign the corresponding postion of the new list to its parent.
 *
 * It works, but mutliple loops. it's O(nxn). too slow.
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Node newHead = new Node(head.val);
        // Process next first
        Node next = head.next;
        Node newParent = newHead;
        while ( next != null) {
            newParent.next = new Node(next.val);
            next = next.next;
            newParent = newParent.next;
        }

        // reset
        next = head;
        newParent = newHead;

        Node random = head.random;

        // Handle random
        while(next != null) {
            if (random != null) {
                // need to find out where random points to
                findRandomPostionAndAssign(head, newHead, newParent, random);
            }
            next = next.next;
            if (next != null && newParent != null) {
                random = next.random;
                newParent = newParent.next;
            }
        }

        return newHead;
    }

    private void findRandomPostionAndAssign(Node head, Node newHead, Node newParent, Node random) {
        if (random == head) {
            newParent.random = newHead;
            return;
        }

        Node start = head;
        Node newStart = newHead;
        while (start != null) {
            if( start == random) {
                newParent.random = newStart;
                return;
            } else {
                findRandomPostionAndAssign(start.next, newStart.next, newParent, random);
            }
            start = start.next;
            newStart = newStart.next;
        }
    }
}
