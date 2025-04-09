package com.mycompany.linkedlistreverse206;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * 0ms Beats 100.00%, 42.26MB Beats 91.92%
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, curr = head.next, next;
        while(true) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            if (next == null) {
                head.next = null;
                return curr;
            }
            curr = next;
        }
    }
}
