package com.mycompany.linkedlistreversebetween92;

/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the
 * nodes of the list from position left to position right, and return the reversed list.
 *
 * 0ms Beats 100.00%, 40.95MB Beats 96.54%
 *
 * Below is another code simpler solution from forum.
 * https://leetcode.com/problems/reverse-linked-list-ii/solutions/2311084/java-c-tried-to-explain-every-step/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || right <= left) return head;

        ListNode curr = head, prev = head;
        int counter = 0;
        while(true) {
            counter ++;
            if (left == counter) {
                if (left == 1) return reverseSegment(curr, right-left+1);
                prev.next = reverseSegment(curr, right-left+1);
                return head;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    private ListNode reverseSegment(ListNode head, int end) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, curr = head.next, next;
        int counter = 2;
        while(true) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            if (counter < end) {
                if (next == null) {
                    head.next = null;
                    return curr;
                }
                curr = next;
                counter ++;
            } else {
                head.next =next;
                return curr;
            }
        }
    }
}
