package com.mycompany.sortlist148;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Approach: just copy the list data to an array, then sort it, then return a new list with sorted data.
 * O(nlogn), but extrax O(n) space.
 * 12ms Beats 30.65%, 55.52 MB Beats 82.72%
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        List<Integer> data = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            data.add(curr.val);
            curr = curr.next;
        }
        Object[] result = data.toArray();
        Arrays.sort(result);
        ListNode top = new ListNode((Integer)result[0]);
        curr = top;
        for(int i=1; i< result.length; i++) {
            curr.next = new ListNode((Integer)result[i]);
            curr=curr.next;
        }
        return top;
    }
}
