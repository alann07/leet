package com.mycompany.linkedlisthascycle141;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * 0ms Beats 100.00%, 44.17MB Beats 95.42%
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode p1=head.next, p2=head.next.next;
        while (true) {
            if (p2 == null) return false;
            if (p1 == p2) return true;
            if (p2.next == null) return false;
            p1 = p1.next;
            p2 = p2.next.next;
        }
    }
}
