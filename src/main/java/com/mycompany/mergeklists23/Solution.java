package com.mycompany.mergeklists23;

/**
 * 23. Merge k Sorted Lists (HARD)
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Merge 1 by 1. Slow
 * 170ms Beats 5.05%, 44.81MB Beats 20.00%
 *
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode first = lists[0];
        for (int i=1; i<lists.length; i++) {
            first = mergeTwoLists(first, lists[i]);
        }
        return first;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
