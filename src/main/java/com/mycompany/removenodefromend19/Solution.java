package com.mycompany.removenodefromend19;

// 0ms Beats 100.00%
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n<=0) return null;
        if (n==1 && head.next==null) return null;
        ListNode p1=head, p2=head;

        int i=0;
        while (i<n) {
            if (p2.next==null) {
                if (i == n-1) {
                    return head.next;
                } else {
                    return head; // n is longer than list size.
                }
            }
            p2 = p2.next;
            i++;
        }

        while (true) {
            if (p2.next == null) {
                p1.next = p1.next.next;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return head;
    }
}
