package com.mycompany.mergeklists23;

/**
 * 23. Merge k Sorted Lists (HARD)
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Try divide and conquer
 * 2ms Beats 84.11%, 44.71MB Beats 28.42%
 */
public class ImprovedSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return dncLists(lists, 0, lists.length-1);
    }

    private ListNode dncLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right-left)/2;
        ListNode l1 = dncLists(lists, left, mid);
        ListNode l2 = dncLists(lists, mid+1, right);
        return mergeTwoLists(l1, l2);
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
