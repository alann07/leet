package com.mycompany.addtwonumber;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        ListNode l1Curr = l1, l2Curr = l2;
        ListNode result = new ListNode();
        ListNode curr = result;
        int increment=0, sum=0;
        while(true) {
            if (l1Curr != null) {
                sum += l1Curr.val;
                l1Curr = l1Curr.next;
            }
            if (l2Curr != null) {
                sum += l2Curr.val;
                l2Curr = l2Curr.next;
            }
            sum += increment;

            if (sum >= 10) {
                curr.val = sum - 10;
                increment = 1;
            } else {
                curr.val = sum;
                increment = 0;
            }
            if (increment > 0 || l1Curr != null || l2Curr != null) {
                curr.next = new ListNode();
                curr = curr.next;
                sum = 0;
            } else {
                break;
            }
        }
        return result;
    }
}