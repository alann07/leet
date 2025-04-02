package com.mycompany.sortlist148;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Approach: reference forum, but it's 14ms.
 * O(nlogn), but extrax O(n) space.
 * 14
 * ms
 * Beats
 * 19.79%
 */
public class improvedSolution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = sortList(slow.next);
        slow.next = null;
        return merge(sortList(head), l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
